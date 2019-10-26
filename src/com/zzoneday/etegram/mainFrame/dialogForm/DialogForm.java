package com.zzoneday.etegram.mainFrame.dialogForm;

import com.zzoneday.etegram.mainFrame.UserAvatar;
import com.zzoneday.etegram.mainFrame.contactList.ContactsList;

import javax.swing.*;
import java.awt.*;

public class DialogForm {
    private JPanel rootPanel;
    private JPanel titlePanel;
    private JPanel dialogPanel;
    private JPanel messagePanel;

    public DialogForm()
    {
        titlePanel.setBackground(Color.WHITE);
        UserAvatar userImage = new UserAvatar("res/2User29.png", "white-mini");
        JLabel userNameToDialog = new JLabel();
        userNameToDialog.setText("Павел Новиков");


        titlePanel.add(userImage.getRootPanel());
        titlePanel.add(userNameToDialog);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
