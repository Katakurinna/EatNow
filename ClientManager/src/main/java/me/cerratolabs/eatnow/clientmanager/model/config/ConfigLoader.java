package me.cerratolabs.eatnow.clientmanager.model.config;

import me.cerratolabs.eatnow.clientmanager.model.ModelConstants;

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

        // Log message 'Trying to load configuration file...'
        logger.info("Trying to load configuration file...");

        // Configuration file from ModelConstants.CONFIG_FILE_PATH path
        File configurationFile = new File(ModelConstants.CONFIG_FILE_PATH);

        // If it does not exist, it generates it
        if (!configurationFile.exists()) {
            BuildConfigFile.createConfigurationFile();

            logger.info("Generated '" + ModelConstants.CONFIG_FILE_PATH + "' file that contains the default configuration");
        }

        // Load properties file
        loadFile();

    }

    public static String getServerAddress() {
        return properties.getProperty(ModelConstants.KEY_SERVER_ADDRESS);
    }

    public static int getServerPort() throws NumberFormatException {
        return Integer.parseInt(properties.getProperty(ModelConstants.KEY_SERVER_PORT));
    }

    private static void loadFile() throws IOException {
        File configurationFile = new File(ModelConstants.CONFIG_FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(configurationFile);
        properties.load(fileInputStream);
    }
}