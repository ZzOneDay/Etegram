package com.zzoneday.etegram.main;

import com.zzoneday.etegram.Education;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainForm extends Education {
    private JPanel rootPanel;
    private JTextArea textArea1;

    MainForm() {
        for (int i = 0; i < contactsList().size(); i++)
        {
            textArea1.append((String) contactsList().get(i));
            System.out.println(contactsList().get(i));
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private ArrayList contactsList()
    {
        ArrayList contactList = new ArrayList<>();
        try {
            contactList = education.getContactsArrayList();
            System.out.println("Получить список контактов - Ок");
        } catch (IOException e) {
            System.out.println("Получить список контактов - Ошибка");
            e.printStackTrace();
        }
        return contactList;
    }
}
