package me.cerratolabs.eatnow.clientmanager.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLog {

    private static final String loggerName = "EatNow";
    private static Logger logger = Logger.getLogger("EatNow");
    private static String LOG_DIRECTORY = "logs";

    private static boolean createDirectoryIfNotExist() {
        File directory = new File(LOG_DIRECTORY);
        return directory.mkdir();

    }

    public static String getLoggerName() {
        return loggerName;
    }

    public static void startLogger() {

        boolean isDirectoryCreated = createDirectoryIfNotExist();
        try {
            String currentDate = getCurrentDateFile();
            String fileName = LOG_DIRECTORY + File.separatorChar + currentDate + "-EatNow.log";
            FileHandler fh = new FileHandler(fileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isDirectoryCreated) {
            logger.info("Folder '" + LOG_DIRECTORY + "' has been created.");
        }
    }

    private static String getCurrentDateFile() {
        return new SimpleDateFormat("yyyy-MM-dd HH.mm ").format(new Date());
    }

}