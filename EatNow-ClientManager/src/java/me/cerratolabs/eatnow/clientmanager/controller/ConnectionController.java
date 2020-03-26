package me.cerratolabs.eatnow.clientmanager.controller;

import me.cerratolabs.eatnow.clientmanager.model.config.ConfigFile;

import java.net.Socket;

public class ConnectionController {

    // Singleton instance
    private static ConnectionController connectionController = new ConnectionController();

    private Socket socket;

    private ConnectionController() {
        ConfigFile.loadPropertiesFile();
    }



    /**
     * This method should return a singleton of the ConnectionController controller.
     *
     * @return ConnectionController instance.
     */
    public static ConnectionController getInstance() {
        return connectionController;
    }

}