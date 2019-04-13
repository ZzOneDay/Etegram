package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;

import javax.swing.*;
import java.io.IOException;

public class EnterCode extends Education implements authorization {
    JButton Logo;
    JTextPane TextPainPleaseTypeYourNumber;
    JButton LogoBlock;
    private JButton buttonContinue;
    private JPanel rootPanel;
    private JTextArea textByEnteredNumber;
    private JPasswordField passwordField1;

    EnterCode() {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        textByEnteredNumber.setText(EnterPhoneNumber.yourNumber);
        buttonContinue.addActionListener(e -> {


            //Безопасность на высоте
            String code = String.valueOf(passwordField1.getPassword());

            try {
                //Вводим код чтобы авторизоваться
                education.authorizationUserByCode(code);
                System.out.println("Проверка кода - Ок");

            } catch (IOException e1) {
                System.out.println("Проверка кода - Ошибка");
                e1.printStackTrace();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
