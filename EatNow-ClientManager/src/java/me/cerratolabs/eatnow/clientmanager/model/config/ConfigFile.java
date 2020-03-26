package me.cerratolabs.eatnow.clientmanager.model.config;

import java.util.Properties;

public class ConfigFile {

    // Singleton instance
    private static ConfigFile configFile = new ConfigFile();

    private Properties properties;

    private ConfigFile() {
        properties = new Properties();
    }

    /**
     * This method should return a singleton of the ConfigFile model.
     *
     * @return ConfigFile instance.
     */
    public static ConfigFile getInstance() {
        return configFile;
    }

    public void setPropertiesFile(){

    }
}