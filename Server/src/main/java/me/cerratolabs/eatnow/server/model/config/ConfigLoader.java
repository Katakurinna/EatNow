package me.cerratolabs.eatnow.server.model.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigLoader {

    // Logger instance
    private static Logger logger = Logger.getLogger("EatNow");

    // Properties file instance
    private static Properties properties = new Properties();

    public static void loadPropertiesFile() throws IOException {
        logger.info("Trying to load configuration file...");

        // Configuration file from ModelConstants.CONFIG_FILE_PATH path
        File configurationFile = new File(ConfigConstants.CONFIG_FILE_PATH);

        // If it does not exist, it generates it
        if (!configurationFile.exists()) {
            BuildConfigFile.createConfigurationFile();
            logger.info("Generated '" + ConfigConstants.CONFIG_FILE_PATH + "' file that contains the default configuration");
        }

        // Load properties file
        loadFile();
    }

    public static int getServerPort() throws NumberFormatException {
        return Integer.parseInt(properties.getProperty(ConfigConstants.SERVER_PORT_NAME));
    }

    private static void loadFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(ConfigConstants.CONFIG_FILE_PATH));
        properties.load(fileInputStream);
    }
}