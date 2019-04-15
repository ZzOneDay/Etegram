package com.zzoneday.etegram.main;

import com.zzoneday.etegram.Education;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainForm {
    private JPanel rootPanel;
    private JTextArea textArea1;

    public MainForm() {

        ArrayList allContactList = contactsList();

        for (int i = 0; i < allContactList.size()-1; i++) {

//        ArrayList contactsList = bridge.contactsGetContacts();
//        for (int i = 0; i < (contactsList.size() - 1); i++) {
//            System.out.println(contactsList.get(i));
//            textArea1.append((String) contactsList().get(i));

            textArea1.append(allContactList.get(i).toString());

            System.out.println(contactsList().get(i));
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private ArrayList contactsList() {
        ArrayList contactList = new ArrayList<>();
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
