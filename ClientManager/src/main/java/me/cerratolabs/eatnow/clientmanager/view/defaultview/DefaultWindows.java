package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import me.cerratolabs.eatnow.clientmanager.controller.AppLog;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alejandro Cerrato Espejo
 */
public class DefaultWindows extends JFrame {

    // Singleton instance
    private static DefaultWindows defaultWindows = new DefaultWindows();

    // Logger
    private JPanel logoPanel = new JPanel();
    private JPanel variablePanel = new JPanel();

    /**
     * This method should return a singleton of the DefaultWindow window.
     *
     * @return DefaultWindows instance.
     * @see #setVariablePanel(JPanel)
     */
    public static DefaultWindows getInstance() {
        return defaultWindows;
    }

    private DefaultWindows() {
        initComponents();
    }

    public void setVariablePanel(JPanel panel) {
        variablePanel.setVisible(false);
        variablePanel.removeAll();
        variablePanel.add(panel);
        variablePanel.setVisible(true);
        setHeight(panel);
        logChangePanel(panel);
    }

    private void logChangePanel(JPanel panel) {
        AppLog.getLogger().info("Changed windows panel to " + panel.getClass().getName());
    }

    private void setHeight(int height) {
        setSize(ViewConstants.WINDOW_WIDTH, 100 + height);
    }

    private void setHeight(JPanel panel) {
        int height = panel.getHeight();
        if (height == 0) {
            height = panel.getPreferredSize().height;
        }
        setHeight(height);
    }


    private void declareVariablePanel() {
        getContentPane().add(variablePanel, BorderLayout.SOUTH);
    }

    private void declareLogoPanel() {
        ImagePanel imgPanel = new ImagePanel(ViewConstants.EATNOW_LOGO_PATH);
        imgPanel.setLayout(new FlowLayout());
        imgPanel.setPreferredSize(new Dimension(ViewConstants.WINDOW_WIDTH, 100));
        logoPanel.add(imgPanel);
        getContentPane().add(logoPanel, BorderLayout.NORTH);
    }

    private void initComponents() {
        // Default windows operations
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            AppLog.getLogger().log(Level.SEVERE, null, e);
        }

        setTitle(ViewConstants.EATNOW_WINDOWS_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);

        declareLogoPanel();
        declareVariablePanel();
    }

    /**
     * @param message     the <code>Object</code> to display
     * @param title       the <code>String</code> to display in the dialog
     *                    title bar
     * @param messageType the type of message that is to be displayed:
     *                    <code>JOptionPane.ERROR_MESSAGE</code>,
     *                    <code>JOptionPane.INFORMATION_MESSAGE</code>,
     *                    <code>JOptionPane.WARNING_MESSAGE</code>,
     *                    <code>JOptionPane.QUESTION_MESSAGE</code>,
     *                    or <code>JOptionPane.PLAIN_MESSAGE</code>
     */
    public void createJOptionPanel(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

}