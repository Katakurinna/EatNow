package me.cerratolabs.eatnow.server.model.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuildConfigFile {

    // Logger instance
    private static Logger logger = Logger.getLogger("EatNow");

    public static void createConfigurationFile() {
        Properties properties = new Properties();
        properties.setProperty(ConfigConstants.SERVER_PORT_NAME, ConfigConstants.SERVER_PORT_DEFAULT_VALUE);

        //FileOutputStream fileOutputStream = null;
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(ConfigConstants.CONFIG_FILE_PATH))) {
            // Get current date
            String date = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date());

            // Generate comments in the file.
            String comments = "EatNow Server Config File\n" +
                    " File creation date: '" + date + "'\n" +
                    " This file has been generated automatically because the configuration file could not be found.";

            // Saved configuration file.
            properties.store(fileOutputStream, comments);
        } catch (IOException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }
}