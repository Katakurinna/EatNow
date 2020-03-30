package me.cerratolabs.eatnow.server.controller.connection;

import lombok.*;

import java.net.ServerSocket;

public class ConnectionController {

    /**
     * Method to get unique instance (Singleton) of {@link ConnectionController}.
     *
     * @return ConnectionController unique instance.
     */
    @Getter private static ConnectionController connectionController = new ConnectionController();

    private ConnectionController() {
        // Some initializations...
    }

    @NonNull private ServerSocket serverSocket;

}