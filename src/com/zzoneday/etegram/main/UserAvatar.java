package com.zzoneday.etegram.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class UserAvatar {

    private BufferedImage image;
    private BufferedImage mask;
    private Color maskColor;

    UserAvatar(String pathname, String type) {
        try {
            image = ImageIO.read(new File(pathname));
            if (type.equals("blue-mini")) {
                //29x29 size
                mask = ImageIO.read(new File("res/GUI Components/mask-blue-mini.png"));
            }
            if (type.equals("dark-gray-big")) {
                //41x41 size
                mask = ImageIO.read(new File("res/GUI Components/mask-gray-online.png"));
            }
            if (type.equals("white-mini")) {
                //29x29 size
                mask = ImageIO.read(new File("res/GUI Components/mask-white-mini.png"));
            }
        } catch (IOException e) {
            System.out.println("Error, Ошибка при загрузке:" + type);
            e.printStackTrace();
        }
    }


    public UserAvatar(String pathname, Color maskColor, Boolean online) {
        this.maskColor = maskColor;
        try {
            image = ImageIO.read(new File(pathname));
            if (maskColor.equals(Color.WHITE))
                //Mask is White {
                if (online) {
                    //User is online
                    mask = ImageIO.read(new File("res/GUI Components/mask-white-online.png"));
                } else {
                    //User is offline
                    mask = ImageIO.read(new File("res/GUI Components/mask-white.png"));
                }
            if (maskColor.equals(Color.gray)) {
                if (online) {
                    //User is online
                    mask = ImageIO.read(new File("res/GUI Components/mask-gray-online.png"));
                } else {
                    //User is offline
                    mask = ImageIO.read(new File("res/GUI Components/mask-gray.png"));
                }
            }
        }
            catch (IOException e) {
                System.out.println("Error, Ошибка при загрузке:" + maskColor + "; " + online);
            e.printStackTrace();
        }


    }

    public Color getColor ()
    {
        return maskColor;
    }

    private JPanel rootPanel;
    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = new JPanel() {
            @Override
            protected void paintBorder(Graphics g) {
                int indent;
                if (image.getHeight()==41)
                {
                    indent = 10;
                }
                else
                    {
                        indent = 0;
                    }

                super.paintComponent(g);
                g.drawImage(image,0,indent,null);
                g.drawImage(mask,0,indent,null);
            }
        };
    }
}

