package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.main.MainForm;

import javax.swing.*;
import java.io.IOException;

public class EnterCode implements authorization {
    JButton Logo;
    JTextPane TextPainPleaseTypeYourNumber;
    JButton LogoBlock;
    private JButton buttonContinue;
    private JPanel rootPanel;
    private JTextArea textByEnteredNumber;
    private JPasswordField passwordField1;

    EnterCode() {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
//        textByEnteredNumber.setText(EnterPhoneNumber.yourNumber);
        buttonContinue.addActionListener(e -> {


            //Безопасность на высоте
            String code = String.valueOf(passwordField1.getPassword());
            boolean codeResult = false;

            try {
                //Вводим код чтобы авторизоваться
                Education.authorizationUserByCode(code);
                codeResult = true;
                System.out.println("Проверка кода - Ок");

            } catch (IOException e1) {
                System.out.println("Проверка кода - Ошибка");
                e1.printStackTrace();
            }
            if (codeResult) {
                MainForm mainForm = new MainForm();
                Education.setNextJPanelInMainJFrame(mainForm.getRootPanel());
            } else {
                JOptionPane.showMessageDialog(rootPanel, "Неверный код");
                passwordField1.grabFocus();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
