package me.cerratolabs.eatnow.server.controller;

import java.net.ServerSocket;

public class ConnectionController {

    // Singleton
    private ConnectionController connectionController = new ConnectionController();

    /**
     * Method to get unique instance (Singleton) of {@link ConnectionController}.
     * @return ConnectionController unique instance.
     */
    public ConnectionController getInstance(){
        return connectionController;
    }

    private ServerSocket serverSocket;

}