package com.zzoneday.etegram.main.contactList;

import com.zzoneday.etegram.main.TimeConverter;
import javax.swing.*;
import java.util.ArrayList;

public class ContactsList {
    private JPanel rootPanel;


    public ContactsList() {
        ArrayList <String> name = new ArrayList<>();
        ArrayList <String> message = new ArrayList<>();
        ArrayList <Long> time = new ArrayList<>();
        ArrayList <String> pathname = new ArrayList<>();
        ArrayList <Boolean> online = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
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
        }

        //КАК ДОБАВИТЬ СКРОЛЛБАР!
        TimeConverter timeConverter = new TimeConverter();

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        for (int i = 0; i < name.size(); i++)
        {
            Contact contact = new Contact(
                    name.get(i),
                    message.get(i),
                    timeConverter.getTimeByTimeConverter(time.get(i)),
                    pathname.get(i),
                    online.get(i));
            jPanel.add(contact.getRootPanel());
        }

        rootPanel.add(jPanel);

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


}

