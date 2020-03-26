package me.cerratolabs.eatnow.clientmanager.model.config;

import me.cerratolabs.eatnow.clientmanager.model.ModelConstants;

import java.io.File;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigFile {

    // Logger instance
    private static Logger logger = Logger.getLogger("EatNow");

    // Properties file instance
    private static Properties properties;

    public static void loadPropertiesFile() {

        // Log message 'Trying to load configuration file...'
        logger.info("Trying to load configuration file...");

        // Configuration file from ModelConstants.CONFIG_FILE_PATH path
        File configurationFile = new File(ModelConstants.CONFIG_FILE_PATH);

        // If it does not exist, it generates it
        if(!configurationFile.exists()){
            BuildConfigFile.createConfigurationFile();

            logger.info("Generated '"+ModelConstants.CONFIG_FILE_PATH+"' file that contains the default configuration");
        }
    }

}