package me.cerratolabs.eatnow.clientmanager.controller;

import me.cerratolabs.eatnow.clientmanager.model.config.ConfigFile;
import me.cerratolabs.eatnow.clientmanager.view.defaultview.DefaultWindows;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientStream extends Thread {


    // Logger
    private Logger logger = AppLog.getLogger();

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ClientStream(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = new DataInputStream(this.socket.getInputStream());
        this.outputStream = new DataOutputStream(this.socket.getOutputStream());
    }

    @Override
    public void run() {
        listener();
    }

    private void listener() {

    }

    public void isConnected() {
        if (socket == null || !socket.isConnected()) {
            String title = "Server connection refused";
            String message = "Cant connect to server, connection refused." + "\n" +
                    "Reconnection will be attempted until successful or you close the application";

            DefaultWindows.getInstance().createJOptionPanel(title, message, JOptionPane.ERROR_MESSAGE);
            // While not connected.
            while (socket == null || !socket.isConnected()) {
                try {
                    socket = new Socket(ConfigFile.getServerAddress(), ConfigFile.getServerPort());
                } catch (Exception e) {
                    logger.log(Level.SEVERE, null, e);
                }
            }
        }
    }

}