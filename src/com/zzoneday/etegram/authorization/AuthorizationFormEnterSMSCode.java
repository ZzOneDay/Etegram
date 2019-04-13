package com.zzoneday.etegram.authorization;

import javax.swing.*;
import java.io.IOException;

public class AuthorizationFormEnterSMSCode extends Loader {
    JButton Logo;
    JTextPane TextPainPleaseTypeYourNumber;
    JButton LogoBlock;
    private JButton buttonContinue;
    private JPanel rootPanel;
    private JTextArea textAreaYouNumberString;
    private JPasswordField passwordField1;

    AuthorizationFormEnterSMSCode() {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        textAreaYouNumberString.setText(AuthorizationFormEnterPhoneNumber.yourNumber);
        buttonContinue.addActionListener(e -> {


            //Безопасность на высоте
            String password = String.valueOf(passwordField1.getPassword());

            try {
                //Вводим код чтобы авторизоваться
                authAuthorizationBySMSCode(password);
                System.out.println("go to main");
                MainForm mainForm = new MainForm();
                Loader.decoration.setContentPanel(mainForm.getRootPanel());

            } catch (IOException e1) {
                System.out.println("Код неверный");
                e1.printStackTrace();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
