package com.zzoneday.etegram.mainFrame.contactList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IconPlusPanel {
    private JPanel rootPanel;
    private JButton button1;
    BufferedImage iconSearch;

    public IconPlusPanel()
    {
        button1.setIcon(new ImageIcon("res/GUI Components/icon-plus.png"));
        button1.setBackground(Color.WHITE);
        button1.setBorder(BorderFactory.createEmptyBorder());
    }

//    private void loadImage() {
//        try {
//            iconSearch = ImageIO.read(new File("res/GUI Components/icon-plus.png"));
//        } catch (IOException e) {
//            System.out.println("Image don't load");
//            e.printStackTrace();
//        }
//    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
