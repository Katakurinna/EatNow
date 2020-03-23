package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alejandro Cerrato Espejo
 */
public class DefaultWindows extends JFrame {

    private static DefaultWindows defaultWindows = new DefaultWindows();
    private JPanel logoPanel;
    private JPanel variablePanel = new JPanel();

    public static DefaultWindows getInstance() {
        return defaultWindows;
    }

    private DefaultWindows() {
        initComponents();
    }

    public void setVariablePanel(JPanel panel) {
        variablePanel.setVisible(false);
        variablePanel = panel;
        variablePanel.setVisible(true);
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        variablePanel = new JPanel();
        logoPanel = new ImagePanel(ViewConstants.EATNOW_LOGO_PATH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        variablePanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1115;
        gridBagConstraints.ipady = 476;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 10, 11, 10);
        getContentPane().add(variablePanel, gridBagConstraints);

        logoPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1115;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(11, 10, 0, 10);
        getContentPane().add(logoPanel, gridBagConstraints);

        pack();
        pack();
        setResizable(false);
        setSize(1135, 604);
        setTitle(ViewConstants.EATNOW_WINDOWS_TITLE);
    }

}
