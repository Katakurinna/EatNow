package me.cerratolabs.eatnow.clientmanager;

import me.cerratolabs.eatnow.clientmanager.controller.AppLog;
import me.cerratolabs.eatnow.clientmanager.view.defaultview.DefaultWindows;
import me.cerratolabs.eatnow.clientmanager.view.login.LoginPanel;

public class MClass {
    public static void main(String[] args) {
        AppLog.startLogger();
        DefaultWindows d = DefaultWindows.getInstance();
        d.setVariablePanel(new LoginPanel());
        d.setVisible(true);
    }
}