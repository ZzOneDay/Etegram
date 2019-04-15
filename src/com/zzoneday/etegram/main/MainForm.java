package com.zzoneday.etegram.main;

import com.zzoneday.etegram.Education;
import org.javagram.response.object.UserContact;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainForm {
    private JPanel rootPanel;

    public MainForm() {

        ArrayList allContactList = contactsList();

        JPanel scroll = new JPanel();

        scroll.setLayout(new BoxLayout(scroll, BoxLayout.Y_AXIS));


        for (int i = 0; i < allContactList.size(); i++)
        {
            scroll.add(new JLabel(allContactList.get(i).toString()));
        }
        JScrollPane scrollPane = new JScrollPane(scroll);

        rootPanel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private ArrayList contactsList() {
        ArrayList contactList = new ArrayList<UserContact>();
        try {
            contactList = Education.getContactsArrayList();
            System.out.println("Получить список контактов - Ок");
        } catch (IOException e) {
            System.out.println("Получить список контактов - Ошибка");
            e.printStackTrace();
        }
        return contactList;
    }
}
