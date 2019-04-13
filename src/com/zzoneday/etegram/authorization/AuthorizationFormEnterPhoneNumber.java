package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;

import javax.swing.*;
import java.io.IOException;

public class AuthorizationFormEnterPhoneNumber implements AuthorizationForm {
    private JPanel rootPanel;
    JButton Logo;
    JTextPane TextPainPleaseTypeYourNumber;
    JButton LogoPhone;
    private JTextArea textAreaFirstCharNumber;
    private JTextField yourNumberField;
    private JButton buttonContinue;

    static String yourNumber;
    private boolean userIsRegistered;


    public AuthorizationFormEnterPhoneNumber() {
        Education education = new Education();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        buttonContinue.addActionListener(e -> {
            try {
                userIsRegistered = education.checkedRegisteredUserByPhone(getEnteredNumber());
            } catch (IOException ex) {
                System.out.println("Номер не зарегистрирован");
                ex.printStackTrace();
            }
        });
        if (userIsRegistered) {
            try {
                education.sentCodeToThisNumber(getEnteredNumber());
            } catch (IOException e1) {
                System.out.println("Не удалось отправить номер");
                e1.printStackTrace();
            }
            AuthorizationFormEnterSMSCode authorizationFormEnterSMSCode = new AuthorizationFormEnterSMSCode();
            education.setNextJPanelInMainJFrame(authorizationFormEnterSMSCode.getRootPanel());

        } else {
            AuthorizationFormRegistration authorizationFormRegistration = new AuthorizationFormRegistration();
            education.setNextJPanelInMainJFrame(authorizationFormRegistration.getRootPanel());
        }

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


    private String getEnteredNumber() {
        return textAreaFirstCharNumber.getText() + yourNumberField.getText();
    }

}
