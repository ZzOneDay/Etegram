package com.zzoneday.etegram;

import javax.swing.*;

public class YourMessageInMainFrame {
    private JPanel messagePanel;
    private JButton ImageMessageUp;
    private JButton ImageMessageRigth;
    private JButton ImageMessageDown;
    private JTextPane textPaneMyMessage;
    private JButton ImageMessageLeft;
    private JPanel panelTimeMessage;
    private JTextArea textAreaMyTimeMessage;
    private JPanel rootPanel;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public YourMessageInMainFrame(String textMessage, String timeMessage)
    {
        textPaneMyMessage.setText(textMessage);
        textAreaMyTimeMessage.setText(timeMessage);
    }
}
