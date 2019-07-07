package com.zzoneday.etegram.main.contactList;
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

    private Boolean target;


    public Contact(String name, String message, String time, String pathname, Boolean online) {
        this.target = false;

        //Получаем автарку
        UserAvatar userAvatar = new UserAvatar(pathname, Color.WHITE, online);
        rootPanel.setBackground(userAvatar.getColor()); //рисуем в цвет фона аватарки
        contactImagePanel.add(userAvatar.getRootPanel()); //добавляем автарку

        //Вводим наши данные
        contactNameJLabel.setText(name);
        contactMessageJLabel.setText(message);
        contactTimeJLabel.setText(time);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    //Активация окна, синяя полоса
    void setTarget ()
    {
        target = !target;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
            timeMessagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (target) {
                        g.setColor(new Color(0, 181, 231));
                        g.drawLine(38, 0, 38, 62);
                        g.drawLine(39, 0, 39, 62);
                        g.drawLine(40, 0, 40, 62);
                    }
                }
            };
        }
    }
