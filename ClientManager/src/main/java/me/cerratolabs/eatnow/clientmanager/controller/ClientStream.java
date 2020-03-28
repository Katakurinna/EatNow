package me.cerratolabs.eatnow.clientmanager.controller;

import me.cerratolabs.eatnow.clientmanager.view.defaultview.DefaultWindows;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientStream extends Thread {


    // Logger
    private Logger logger = AppLog.getLogger();

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;


    // Server info
    private String serverAddress;
    private int serverPort;

    public ClientStream(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        if (!connect()) isConnected();
    }

    @Override
    public void run() {
        listener();
    }

    private void listener() {

    }


    public void isConnected() {
        if (socket == null || !socket.isConnected()) {

            // The user receive a message on the screen saying the server could not be connected and will continue trying.
            new Thread(DefaultWindows.getInstance()::errorConnectionDialog).start();

            // While not connected.
            while (socket == null || !socket.isConnected()) {
                try {
                    connect();
                    Thread.sleep(ConnectionConstants.RECONNECT_SLEEP_TIME);
                } catch (Exception e) {
                    logger.log(Level.SEVERE, null, e);
                }
            }
        }
    }

    private boolean connect() {
        try {
            socket = new Socket(serverAddress, serverPort);
            this.inputStream = new DataInputStream(this.socket.getInputStream());
            this.outputStream = new DataOutputStream(this.socket.getOutputStream());
            // Has been conected
            return true;
        } catch (Exception e) {
            String errorMessage = "Error trying to connect to eatnow-server: '" + e.getMessage() + "'.";
            logger.severe(errorMessage);

            // Error trying to reconnect
            return false;
        }
    }

}