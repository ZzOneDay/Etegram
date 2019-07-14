package com.zzoneday.etegram.main.contactList;

import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.main.UserAvatar;

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


    public Contact(String name, String message, String time, String pathname, Boolean online) {
        //Получаем автарку
        userAvatar = new UserAvatar(pathname, online);
        rootPanel.setBackground(userAvatar.getColor()); //рисуем в цвет фона
        contactImagePanel.add(userAvatar.getRootPanel()); //добавляем автарку
        //Вводим наши данные
        contactNameJLabel.setText(name);
        contactMessageJLabel.setText(message);
        contactTimeJLabel.setText(time);
        //Подгоняем шрифты
        contactNameJLabel.setFont(Education.getCustomFont("OpenSansSemiBold", 16));
        contactMessageJLabel.setFont(Education.getCustomFont("OpenSansRegular", 12));
        contactTimeJLabel.setFont(Education.getCustomFont("OpenSansLight",10));

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


    private void createUIComponents() {
        // TODO: place custom component creation code here
        timeMessagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (target) {
                    g.setColor(new Color(0, 181, 231));
                    g.drawLine(46, 0, 46, 62);
                    g.drawLine(47, 0, 47, 62);
                    g.drawLine(48, 0, 48, 62);
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
