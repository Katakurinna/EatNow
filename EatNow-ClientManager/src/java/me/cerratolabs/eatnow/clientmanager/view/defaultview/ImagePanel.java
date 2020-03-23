package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(File imagePath) {
        try {
            image = ImageIO.read(imagePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ImagePanel(String imagePath) {
        this(new File(imagePath));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}