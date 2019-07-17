package com.zzoneday.etegram.mainFrame.contactList;

import com.zzoneday.etegram.TimeConverter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContactsList {
    private JPanel rootPanel;


    /**Необходимо:
     * 1. Создать смену таргета по клику на Окно contact.get.setTarget через Listener
     * 2. При наведение на JScrollPanel должен появляться ScrollBar
     * 3. Увеличить интенстивность передвижения списка по колесику мышки
     */



    public ContactsList() {
        ArrayList<Contact> contact = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> message = new ArrayList<>();
        ArrayList<Long> time = new ArrayList<>();
        ArrayList<String> pathname = new ArrayList<>();
        ArrayList<Boolean> online = new ArrayList<>();

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

        TimeConverter timeConverter = new TimeConverter();

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        ScrollPane scrollPanel = new ScrollPane(ScrollPane.SCROLLBARS_NEVER);

        for (int i = 0; i < name.size(); i++) {
            Contact newContact = new Contact(
                    name.get(i),
                    message.get(i),
                    timeConverter.getTimeByTimeConverter(time.get(i)),
                    pathname.get(i),
                    online.get(i));
            jPanel.add(newContact.getRootPanel());
            contact.add(newContact);
        }
        scrollPanel.add(jPanel);

        contact.get(1).setTarget();

        rootPanel.add(scrollPanel);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


}

