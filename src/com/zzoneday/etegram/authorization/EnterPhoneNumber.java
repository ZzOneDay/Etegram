package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;

import javax.swing.*;
import java.io.IOException;

public class EnterPhoneNumber implements authorization {
    private JPanel rootPanel;
    JButton Logo;
    JTextPane TextPainPleaseTypeYourNumber;
    JButton LogoPhone;
    private JTextArea textAreaFirstCharNumber;
    private JTextField yourNumberField;
    private JButton buttonContinue;

    static String yourNumber;


    public EnterPhoneNumber() {
        Education education = new Education();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        buttonContinue.addActionListener(e -> {
            if (education.getResultUserIsRegistered(getEnteredNumber())) {
                try {
                    education.sentCodeToThisNumber(getEnteredNumber());
                } catch (IOException e1) {
                    System.out.println("Не удалось отправить номер");
                    e1.printStackTrace();
                }
                EnterCode authorizationFormEnterSMSCode = new EnterCode();
                education.setNextJPanelInMainJFrame(authorizationFormEnterSMSCode.getRootPanel());

            } else {
                Registration authorizationFormRegistration = new Registration();
                education.setNextJPanelInMainJFrame(authorizationFormRegistration.getRootPanel());
            }
        });

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


    private String getEnteredNumber() {
        System.out.println(textAreaFirstCharNumber.getText() + yourNumberField.getText());
        return textAreaFirstCharNumber.getText() + yourNumberField.getText();
    }

}
