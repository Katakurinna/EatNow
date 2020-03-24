package me.cerratolabs.eatnow.clientmanager.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLog {
    private static Logger logger;

    public static void startLogger() {
        logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            String currentDate = getCurrentDateFile();
            String fileName = currentDate + " - EatNow.log";
            fh = new FileHandler(fileName);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addInfo("Iniciated application.");
    }
    private static String getCurrentDateFile() {
        return new SimpleDateFormat("yyyy-MM-dd HH.mm ").format(new Date());
    }

    private static String getCurrentDate() {
        return new SimpleDateFormat("[yyyy/MM/dd HH:mm]").format(new Date());
    }

    public static void addInfo(Object exception) {
        String message = "INFO: " + getCurrentDate() + ": ";
        logger.log(Level.INFO, message, exception);
    }

    public static void addWarning(Object exception) {
        String message = "WARNING: " + getCurrentDate() + ": ";
        logger.log(Level.WARNING, message, exception);
    }

    public static void addError(Object exception) {
        String message = "ERROR: " + getCurrentDate() + ": ";
        logger.log(Level.SEVERE, message, exception);
    }
}

