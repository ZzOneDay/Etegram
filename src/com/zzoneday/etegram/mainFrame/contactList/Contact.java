package com.zzoneday.etegram.mainFrame.contactList;

import com.zzoneday.etegram.CustomFont;
import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.mainFrame.UserAvatar;

import javax.swing.*;
import java.awt.*;

public class Contact {
    private JPanel rootPanel;
    private JPanel contactImagePanel;
    private JPanel nameContactMessagePanel;
    private JPanel timeMessagePanel;
    private JLabel contactNameJLabel;
    private JLabel contactTimeJLabel;
    private JLabel contactMessageJLabel;

    private Boolean target = false;
    private UserAvatar userAvatar;

    private String name;


    Contact(String name, String message, String time, String pathname, Boolean online) {
        //Получаем автарку
        userAvatar = new UserAvatar(pathname, online);
        rootPanel.setBackground(userAvatar.getColor()); //рисуем в цвет фона
        contactImagePanel.add(userAvatar.getRootPanel()); //добавляем автарку
        //Вводим наши данные
        contactNameJLabel.setText(name);
        contactMessageJLabel.setText(message);
        contactTimeJLabel.setText(time);
        //Подгоняем шрифты
        contactNameJLabel.setFont(CustomFont.getCustomFont("OpenSansSemiBold", 16));
        contactMessageJLabel.setFont(CustomFont.getCustomFont("OpenSansRegular", 12));
        contactTimeJLabel.setFont(CustomFont.getCustomFont("OpenSansLight",10));

        this.name = name;

        //Рамка для контакта
//        rootPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    //Активация окна, синяя полоса
    void setTarget() {
        //Меняем автарку, и полоску рисуем
        userAvatar.changeTargetAvatar();
        rootPanel.setBackground(userAvatar.getColor()); //рисуем в цвет фона
        target = !target;
        rootPanel.repaint();

    }

    void setOnlineOrOffline() {
        //Противополножное от того что есть
        userAvatar.changeOnlineAvatar();
        rootPanel.repaint();
    }

    public String getName() {
        return name;
    }

    //    @Override
//    public String toString() {
//        return name;
//    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        timeMessagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (target) {
                    g.setColor(new Color(0, 181, 231));
                    int y = 58;
                    for (int x = 43; x<48; x++) {
                        g.drawLine(x, 0, x, y);
                        g.drawLine(x, 0, x, y);
                        g.drawLine(x, 0, x, y);
                    }
                    contactTimeJLabel.setVisible(false);
                } else {
                    //Если контакт выбран, время сообщения скрыто, если не выбран, время появляется
                    contactTimeJLabel.setVisible(true);
                }
            }
        };

        rootPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(204,205,205));
                g.drawLine(0,60,250,60);
            }
        };
    }
}
