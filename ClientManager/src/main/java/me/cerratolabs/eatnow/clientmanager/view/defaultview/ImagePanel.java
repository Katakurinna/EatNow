package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import me.cerratolabs.eatnow.clientmanager.controller.AppLog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImagePanel extends JPanel {

    // Logger
    private Logger logger = Logger.getLogger(AppLog.getLoggerName());

    private BufferedImage image;

    public ImagePanel(File url) {
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    public ImagePanel(String url) {
        this(new File(url));
    }

    public ImagePanel(URL url) {
        try {
            System.out.println(url);
            image = ImageIO.read(url);
        } catch (IOException e) {
            logger.log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}