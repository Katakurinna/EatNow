package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import java.net.URL;

/**
 * @author Alejandro Cerrato Espejo
 */
public class ViewConstants {
    // Image paths
    public static URL EATNOW_LOGO_PATH = getResource("images/EatNow-Logo.png");
    public static URL EATNOW_LOADING_GIF = getResource("images/loading.gif");

    // Windows defaults strings
    public static final String EATNOW_WINDOWS_TITLE = "Eat Now Maintenance Company Application";

    // Windows defaults sizes
    public static final int WINDOW_HEIGHT = 500;
    public static final int WINDOW_WIDTH = 1135;

    private static URL getResource(String path){
        return ViewConstants.class.getClassLoader().getResource(path);
    }
}