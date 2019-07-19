package com.zzoneday.etegram.mainFrame;

import com.zzoneday.etegram.CustomFont;
import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.mainFrame.contactList.ContactsList;
import com.zzoneday.etegram.mainFrame.contactList.IconPlusPanel;
import com.zzoneday.etegram.mainFrame.contactList.SearchPanel;
import org.telegram.api.TLUserProfilePhoto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainForm {
    private JPanel rootPanel;
    private JPanel titlePanel;
    private JSplitPane mainPanel;
    private JPanel contactsPanel;
    private JPanel UpContactsPanel;
    private JPanel downContactsPanel;
    private JButton buttonSetting;
    private JLabel userName;
    private JPanel userIcon;
    private JPanel contactsMain;
    private JPanel mainContactsPanel;

    private BufferedImage logoMicro;
    private BufferedImage iconSetting;

    public MainForm() {
        loadImage();

        //Самая верхняя панель, титл бар
        Color myBlue = new Color(0, 180, 231);
        titlePanel.setBackground(myBlue);
        buttonSetting.setBackground(myBlue);
        buttonSetting.setIcon(new ImageIcon("res/GUI Components/icon-settings.png"));
        buttonSetting.setBorder(null);

        //Верхняя панель, с Иконкой, ИмяПользователя, Настройки

        if (Education.workInOnline)
        {
////            UserAvatar userImage = new UserAvatar(), "blue-mini");
//            userIcon.add(userImage.getRootPanel());
//            userName.setText(
//                    Education.authAuthorization.getUser().getFirstName() +
//                            Education.authAuthorization.getUser().getLastName());

        }
        else {
            UserAvatar userImage = new UserAvatar("res/User29.png", "blue-mini");
            userIcon.add(userImage.getRootPanel());
            userName.setText("Павел Новиков");
        }

        userName.setForeground(Color.LIGHT_GRAY);
        userName.setFont(CustomFont.getCustomFont("OpenSansRegular", 15));

        //КонтактЛист
        ContactsList contactsList = new ContactsList();
        contactsMain.add(contactsList.getRootPanel());

        //Поиск КонтактЛист
        SearchPanel searchPanel = new SearchPanel(new ScrollPane());
        UpContactsPanel.add(searchPanel.getRootPanel());

        //Нижняя панель КонтактЛиста
        IconPlusPanel iconPlusPanel = new IconPlusPanel();
        downContactsPanel.add(iconPlusPanel.getRootPanel());

//        JPanel background = new JPanel( new BorderLayout() );
//        background.add( new JTextArea(), BorderLayout.CENTER );
//        background.add( new JButton("Button"), BorderLayout.SOUTH );
//
//        contactsMain.add(background);


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



    }
//
//    public JPanel getRootPanel() {
//        return rootPanel;
//    }
//
//    private ArrayList contactsJList() {
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
