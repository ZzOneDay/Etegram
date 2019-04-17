package com.zzoneday.etegram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Decoration {
    private JButton hideButton;
    private JButton closeButton;
    private JPanel rootPanel;
    private JPanel contentPanel;
    private JPanel titlePanel;
    private JFrame jFrame;

    Decoration(JFrame jFrame) {

        this.jFrame = jFrame;
        titlePanel.setBackground(new Color(230, 230, 230));

        hideButton.setIcon(new ImageIcon("res/GUI Components/icon-hide.png"));
        closeButton.setIcon(new ImageIcon("res/GUI Components/icon-close.png"));

        closeButton.addActionListener(e -> closeApp());
        hideButton.addActionListener(e -> hideApp());
    }

    void setContentPanel(Component component) {
        contentPanel.removeAll(); //Очищаем
        contentPanel.add(component);
        contentPanel.revalidate(); //Растягивает
        contentPanel.repaint(); //Перерисовка
    }

    private void hideApp() {
//        Не работает на MacOS!!!!!!!!!!!!!
//        jFrame.setExtendedState(Frame.ICONIFIED);
//        jFrame.setState(Frame.ICONIFIED);
        jFrame.setState(jFrame.getExtendedState() | Frame.ICONIFIED);
    }

    private void closeApp() {
        jFrame.dispose();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        contentPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image background = null;
                try {
                    background = ImageIO.read(new File("res/GUI Components/background.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(background,0,0,null);
            }
        };
    }
}
