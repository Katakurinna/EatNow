package me.cerratolabs.eatnow.clientmanager.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLog {

    private static Logger logger = Logger.getLogger("MyLog");
    private static String LOG_DIRECTORY = "logs";

    private static boolean createDirectoryIfNotExist() {
        File directory = new File(LOG_DIRECTORY);
        return directory.mkdir();
    }

    public static void startLogger() {

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

        info("Initiated application.");

        if (createDirectoryIfNotExist()) {
            info("Folder '" + LOG_DIRECTORY + "' has been created.");
        } else {
            info("Folder '" + LOG_DIRECTORY + "' already exist.");
        }
    }

    private static String getCurrentDateFile() {
        return new SimpleDateFormat("yyyy-MM-dd HH.mm ").format(new Date());
    }

    private static String getCurrentDate() {
        return new SimpleDateFormat("[yyyy/MM/dd HH:mm]").format(new Date());
    }

    public static void info(Object exception) {
        String message = getCurrentDate() + ": ";
        logger.log(Level.INFO, message, exception);
    }

    public static void info(String exception) {
        String message = getCurrentDate() + ": ";
        logger.log(Level.INFO, message + exception);
    }

    public static void warning(Object exception) {
        String message = getCurrentDate() + ": ";
        logger.log(Level.WARNING, message, exception);
    }

    public static void warning(String exception) {
        String message = getCurrentDate() + ": ";
        logger.log(Level.WARNING, message + exception);
    }

    public static void error(Throwable exception) {
        String message = getCurrentDate() + ": ";
        logger.log(Level.SEVERE, message, exception);
    }

    public static void error(String message, Throwable exception) {
        String pad = getCurrentDate() + ": ";
        logger.log(Level.SEVERE, pad + message, exception);
    }

    public static void error(String message) {
        String pad = getCurrentDate() + ": ";
        logger.log(Level.SEVERE, pad + message);
    }

}