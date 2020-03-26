package me.cerratolabs.eatnow.clientmanager.model.config;

import java.util.Properties;

public class BuildConfigFile {
    // Singleton instance
    private static BuildConfigFile buildConfigFile = new BuildConfigFile();

    private Properties properties;

    private BuildConfigFile() {
        properties = new Properties();

    }

    /**
     * This method should return a singleton of the BuildConfigFile model.
     *
     * @return BuildConfigFile instance.
     */
    public static BuildConfigFile getInstance() {
        return buildConfigFile;
    }

}