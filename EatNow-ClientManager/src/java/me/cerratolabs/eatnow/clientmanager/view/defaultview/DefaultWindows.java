package me.cerratolabs.eatnow.clientmanager.view.defaultview;

import me.cerratolabs.eatnow.clientmanager.controller.AppLog;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alejandro Cerrato Espejo
 */
public class DefaultWindows extends JFrame {

    // Singleton instance
    private static DefaultWindows defaultWindows = new DefaultWindows();

    // Logger
    private Logger logger = Logger.getLogger(AppLog.getLoggerName());

    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 1135;

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

    private void setHeight(int height) {
        setSize(WINDOW_WIDTH, 100 + height);
    }

    private void setHeight(JPanel panel) {
        int height = panel.getHeight();
        if (height == 0) {
            height = panel.getPreferredSize().height;
        }
        setHeight(height);
    }

    public void setVariablePanel(JPanel panel) {
        variablePanel.setVisible(false);
        variablePanel.removeAll();
        variablePanel.add(panel);
        variablePanel.setVisible(true);
        setHeight(panel);
    }

    private void declareVariablePanel() {
        getContentPane().add(variablePanel, BorderLayout.SOUTH);
    }

    private void declareLogoPanel() {
        ImagePanel imgPanel = new ImagePanel(ViewConstants.EATNOW_LOGO_PATH);
        imgPanel.setLayout(new FlowLayout());
        imgPanel.setPreferredSize(new Dimension(WINDOW_WIDTH - 20, 100));
        logoPanel.add(imgPanel);
        getContentPane().add(logoPanel, BorderLayout.NORTH);
    }

    private void initComponents() {
        // Default windows operations
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        setTitle(ViewConstants.EATNOW_WINDOWS_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setResizable(false);

        declareLogoPanel();
        declareVariablePanel();
    }

}