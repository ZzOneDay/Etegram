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
        closeButton.setBorder(BorderFactory.createEmptyBorder());


        hideButton.addActionListener(e -> hideApp());
        hideButton.setBorder(BorderFactory.createEmptyBorder());
//        hideButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//                hideButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//                super.mouse
////                hideButton.setBorder(BorderFactory.createEmptyBorder());
//            }
//        });
    }




    void setContentPanel(Component component) {
        contentPanel.removeAll(); //Очищаем
        contentPanel.add(component);
        contentPanel.revalidate(); //Растягивает
        contentPanel.repaint(); //Перерисовка
    }

    private void hideApp() {
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
        rootPanel = new JPanel()
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
                g.drawImage(background,0,34,null);
            }
        };
    }
}
