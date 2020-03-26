package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import javax.swing.*;
public class LoadingPanel extends JPanel {

    public LoadingPanel() {
        initComponents();
    }

    private void initComponents() {
        Icon imgIcon = new ImageIcon(ViewConstants.EATNOW_LOADING_GIF);
        JLabel label = new JLabel(imgIcon);
        add(label);
        setSize(ViewConstants.WINDOW_WIDTH, ViewConstants.WINDOW_HEIGHT);
    }
}