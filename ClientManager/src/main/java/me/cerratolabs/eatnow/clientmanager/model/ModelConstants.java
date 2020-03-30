package me.cerratolabs.eatnow.clientmanager.model;

import me.cerratolabs.eatnow.clientmanager.controller.AppLog;

import java.net.URI;
import java.util.logging.Logger;

public class ModelConstants {

    // Logger
    private static Logger logger = AppLog.getLogger();

    // Paths
    public static URI CONFIG_FILE_PATH = getResource("configFiles/configuration.conf");
    public static URI TOKEN_FILE_PATH = getResource("configFiles/token.dat");

    // Properties file keys
    public static final String KEY_SERVER_ADDRESS = "ServerAddress";
    public static final String KEY_SERVER_PORT = "ServerPort";


    private static URI getResource(String path) {
        try {
            return ModelConstants.class.getClassLoader().getResource(path).toURI();
        } catch (Exception e) {
            logger.warning("'" + path + "' file not found.");
            return null;
        }
    }
}