package com.zzoneday.etegram;

import javax.swing.*;
import java.awt.*;

public class Decoration {
    private JButton minimizeButton;
    private JButton closeButton;
    private JPanel rootPanel;
    private JPanel contentPanel;
    private JFrame jFrame;

    public Decoration(JFrame jFrame) {
        this.jFrame = jFrame;
        closeButton.addActionListener(e -> closeApp());
        minimizeButton.addActionListener(e -> minimizeApp());
    }

    public void setContentPanel(Component component) {
        contentPanel.removeAll(); //Очищаем
        contentPanel.add(component);
        contentPanel.revalidate(); //Растягивает
        contentPanel.repaint(); //Перерисовка
    }

    private void minimizeApp() {
        jFrame.setState(JFrame.ICONIFIED);
    }

    private void closeApp() {
        jFrame.dispose();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
