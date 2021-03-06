package me.cerratolabs.eatnow.clientmanager.controller;

import me.cerratolabs.eatnow.clientmanager.model.ModelConstants;
import me.cerratolabs.eatnow.clientmanager.model.config.ConfigLoader;
import me.cerratolabs.eatnow.clientmanager.view.defaultview.DefaultWindows;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionController {

    // Singleton instance
    private static ConnectionController connectionController = new ConnectionController();

    /**
     * This method should return a singleton of the ConnectionController controller.
     *
     * @return ConnectionController instance.
     */
    public static ConnectionController getInstance() {
        return connectionController;
    }

    // Logger
    private Logger logger = AppLog.getLogger();

    // Client socket
    private Socket socket;

    // Client Communicator
    private ClientStream clientStream;

    private ConnectionController() {
        try {
            ConfigLoader.loadPropertiesFile();
        } catch (IOException e) {
            String errorMSG = "Cant load properties file: '" + ModelConstants.CONFIG_FILE_PATH + "'.";
            logger.severe(errorMSG);
            logger.log(Level.SEVERE, null, e);
        }



            clientStream = new ClientStream(ConfigLoader.getServerAddress(), ConfigLoader.getServerPort());


    }

}