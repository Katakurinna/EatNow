package me.cerratolabs.eatnow.clientmanager.controller;

import java.net.Socket;

public class ConnectionController {

    // Singleton instance
    public static ConnectionController connectionController = new ConnectionController();

    private Socket socket;

    private ConnectionController() {

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