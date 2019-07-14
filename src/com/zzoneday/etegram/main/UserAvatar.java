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
    private Boolean target;
    private Boolean online;

    private JPanel rootPanel;
    private Color customGray = new Color(231,231,231);

    UserAvatar(String pathname, String type) {
        try {
            image = ImageIO.read(new File(pathname));
            if (type.equals("blue-mini")) {
                //29x29 size
                mask = ImageIO.read(new File("res/GUI Components/mask-blue-mini-clear.png"));
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


    public UserAvatar(String pathname, Boolean online) {
        this.online = online;
        this.target = false;

        try {
            image = ImageIO.read(new File(pathname));
            setMask(target,online);
        }
            catch (IOException e) {
                System.out.println("Error, Ошибка при загрузке:\nЦель " + target + "; Онлайн: " + online);
            e.printStackTrace();
        }


    }
    private void setMask(Boolean target, Boolean online) {
        //Переосознал, заместо того чтобы задовать цвет, мы указывает Target и цвет будет автоматически.
        try {
            if (target)
                //Mask is White
                maskColor = Color.WHITE;
                if (online) {
                    //User is online
                    mask = ImageIO.read(new File("res/GUI Components/mask-white-online.png"));
                } else {
                    //User is offline
                    mask = ImageIO.read(new File("res/GUI Components/mask-white.png"));
                }
            if (!target) {
                //Mask is Gray
                maskColor = (customGray);
                if (online) {
                    //User is online
                    mask = ImageIO.read(new File("res/GUI Components/mask-gray-online.png"));
                } else {
                    //User is offline
                    mask = ImageIO.read(new File("res/GUI Components/mask-gray-ok.png"));
                }
            }
            rootPanel.setBackground(maskColor);
        } catch (IOException e) {
            System.out.println("Error, Ошибка при загрузке:\nМаска: " + maskColor + "; Онлайн: " + online);
            e.printStackTrace();

        }
    }


    public Color getColor ()
    {
        return maskColor;
    }

    public void changeOnlineAvatar ()
    {
        online=!online;
        setMask(this.target, online);

    }
    public void changeTargetAvatar ()
    {
        target = !target;
        setMask(target,this.online);
    }







    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = new JPanel() {
            @Override
            protected void paintBorder(Graphics g) {
                int indentY;
                int indentX;
                if (image.getHeight()==41)
                {
                    indentY = 10;
                    indentX = 10;

                }
                else
                    {
                        indentY = 0;
                        indentX = 0;
                    }

                super.paintComponent(g);
                g.drawImage(image,indentX,indentY,null);
                g.drawImage(mask,indentX,indentY,null);
                g.setColor(new Color(204,205,205));
                g.drawLine(0,60,60,60);
            }
        };
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}

