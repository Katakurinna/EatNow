package me.cerratolabs.eatnow.server.model.config;

import me.cerratolabs.eatnow.server.controller.logger.AppLog;

import java.net.URI;
import java.util.logging.Logger;

public class ConfigConstants {

    // Logger
    private static final Logger LOG = AppLog.getLogger();

    // Paths
    public static URI CONFIG_FILE_PATH = getResource("configFiles/configuration.conf");
    public static URI TOKEN_FILE_PATH = getResource("configFiles/token.dat");

    // Properties file keys
    public static final String SERVER_PORT_NAME = "ServerPort";

    // Properties file value
    public static final String SERVER_PORT_DEFAULT_VALUE = "3121";

    private static URI getResource(String path) {
        try {
            return ConfigConstants.class.getClassLoader().getResource(path).toURI();
        } catch (Exception e) {
            LOG.warning("'" + path + "' file not found.");
            return null;
        }
    }
}