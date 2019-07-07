package com.zzoneday.etegram;

import javax.swing.*;

public class ContactFormInMainFrame {
    private JPanel rootPanel;
    private JButton ImageContact;
    private JTextArea textAreaTimeLastOnlineStatus;
    private JTextArea textAreaContactLastMessage;
    private JTextArea textAreaContactFullName;
    private JPanel rootPanelTest;
    private JPanel rootPanelest2;

    public ContactFormInMainFrame (String contactFullName, String contactLastMessage, String timeLastOnline, boolean online) {
        textAreaContactFullName.setText(contactFullName);
        textAreaContactLastMessage.setText(contactLastMessage);
        textAreaTimeLastOnlineStatus.setText(timeLastOnline);


        if (online)
        {
            ImageContact.setText("ON");
        }
        else
            ImageContact.setText("OF");

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
