package me.cerratolabs.eatnow.clientmanager;

import me.cerratolabs.eatnow.clientmanager.controller.AppLog;
import me.cerratolabs.eatnow.clientmanager.controller.ConnectionController;
import me.cerratolabs.eatnow.clientmanager.view.defaultview.DefaultWindows;
import me.cerratolabs.eatnow.clientmanager.view.defaultview.LoadingPanel;

import java.util.logging.Logger;

public class MClass {

    private static Logger logger = Logger.getLogger(AppLog.getLoggerName());

    public static void main(String[] args) {
        AppLog.startLogger();
        DefaultWindows d = DefaultWindows.getInstance();
        d.setVariablePanel(new LoadingPanel());
        d.setVisible(true);
        logger.info("Application has been initiated.");
        ConnectionController.getInstance();
    }
}