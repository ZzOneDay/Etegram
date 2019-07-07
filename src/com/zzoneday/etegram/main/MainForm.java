package com.zzoneday.etegram.main;

import com.zzoneday.etegram.Education;
import org.javagram.response.object.UserContact;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainForm {
    private JPanel rootPanel;
    private JPanel titlePanel;
    private JSplitPane mainPanel;
    private JPanel contactsPanel;
    private JPanel UpContactsPanel;
    private JList contactsList;
    private JPanel downContactsPanel;
    private JButton buttonSetting;
    private JButton button3;
    private JLabel userName;
    private JButton button1;
    private JPanel userIcon;

    private BufferedImage logoMicro;
    private BufferedImage iconSetting;

    public MainForm() {
        loadImage();

        Color myBlue = new Color(0, 180, 231);
        titlePanel.setBackground(myBlue);
        buttonSetting.setBackground(myBlue);
        buttonSetting.setIcon(new ImageIcon("res/GUI Components/icon-settings.png"));
        buttonSetting.setBorder(null);

        UserAvatar userImage = new UserAvatar("res/User29.png","blue-mini");
        userIcon.add(userImage.getRootPanel());
        userName.setText("Павел Новиков");
        userName.setForeground(Color.LIGHT_GRAY);
        userName.setFont(Education.getCustomFont("OpenSansRegular", 15));

//        titlePanel.add(userImage.getRootPanel());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logoMicro,24,14,null);
            }
        };

    }

    private void loadImage() {
        try {
            logoMicro = ImageIO.read(new File("res/GUI Components/logo-micro.png"));
        } catch (IOException e) {
            System.out.println("Image don't load");
            e.printStackTrace();
        }
    }


//        ArrayList allContactList = contactsList();
//
//        JPanel scroll = new JPanel();
//
//        scroll.setLayout(new BoxLayout(scroll, BoxLayout.Y_AXIS));
//
//
//        for (int i = 0; i < allContactList.size(); i++)
//        {
//            scroll.add(new JLabel(allContactList.get(i).toString()));
//        }
//        JScrollPane scrollPane = new JScrollPane(scroll);
//
//        rootPanel.add(scrollPane, BorderLayout.CENTER);
//    }
//
//    public JPanel getRootPanel() {
//        return rootPanel;
//    }
//
//    private ArrayList contactsList() {
//        ArrayList contactList = new ArrayList<UserContact>();
//        try {
//            contactList = Education.getContactsArrayList();
//            System.out.println("Получить список контактов - Ок");
//        } catch (IOException e) {
//            System.out.println("Получить список контактов - Ошибка");
//            e.printStackTrace();
//        }
//        return contactList;
//    }
}
