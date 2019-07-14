package com.zzoneday.etegram.main.contactList;

import com.zzoneday.etegram.main.TimeConverter;
import javax.swing.*;
import java.util.ArrayList;

public class List {
    private JPanel rootPanel;
    private JButton button1;
    private JButton button2;


    public List() {
        ArrayList <String> name = new ArrayList<>();
        ArrayList <String> message = new ArrayList<>();
        ArrayList <Long> time = new ArrayList<>();
        ArrayList <String> pathname = new ArrayList<>();
        ArrayList <Boolean> online = new ArrayList<>();
        ArrayList <Contact> contactsList = new ArrayList<>();

        name.add("Pavel Novikov");
        name.add("Karina Bugaichenko");

        message.add("Hello Pavel");
        message.add("Hello Karina");
        time.add(1563122596L);
        time.add(1563038595L);
        pathname.add("res/User41.png");
        pathname.add("res/2User41.png");
        online.add(true);
        online.add(false);

        TimeConverter timeConverter = new TimeConverter();

        for (int i = 0; i < name.size(); i++)
        {
            Contact contact = new Contact(
                    name.get(i),
                    message.get(i),
                    timeConverter.getTimeByTimeConverter(time.get(i)),
                    pathname.get(i),
                    online.get(i));
            contactsList.add(contact);
            rootPanel.add(contact.getRootPanel());
        }


        button1.addActionListener(e -> contactsList.get(0).setTarget());
        button2.addActionListener(e -> contactsList.get(1).setOnlineOrOffline());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

