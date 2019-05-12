package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.main.MainForm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterCode implements authorization {
    private JButton buttonContinue;
    private JPanel rootPanel;
    private JPasswordField passwordField1;
    private JPanel logoPanel;
    private JLabel mainText;
    private JPanel enterPhoneNumberJPanel;
    private JTextField textField1;
    private JPanel buttonJPanel;
    private JButton buttonNext;
    private JPanel MainText;
    private JLabel textYourNumber;

    private BufferedImage logo;
    private BufferedImage iconLock;
    private BufferedImage buttonBackground;

    EnterCode() {
        //Основные пункты загрузки
        loadImage();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        //Основной текст
        mainText.setText(
                "<html><center>На данный номер телефона было отправлено\n SMS-сообщение с кодом подтверждения. " +
                "Пожалуйста, введите этот код в поле ниже:<center></html>");
        mainText.setFont(Education.getCustomFont("regular", 14f));
        mainText.setForeground(Color.WHITE);

        //Текст номера телефона пользователя
        textYourNumber.setText("+7 900 707-92-29");
        textYourNumber.setBackground(new Color(0, 0, 0, 0));
        textYourNumber.setFont(Education.getCustomFont("light", 38f));
        textYourNumber.setForeground(Color.lightGray);

        //Форма для ввода кода
        passwordField1.setBackground(new Color(0, 0, 0, 0));
        passwordField1.setFont(Education.getCustomFont("regular", 34f));
        passwordField1.setForeground(Color.white);
        passwordField1.setBorder(null);

        //Кнопка "Продолжить" для перехода в следующее окно
        buttonNext.setText("ПРОДОЛЖИТЬ");
        buttonNext.setFont(Education.getCustomFont("regular",20f));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setIcon(new ImageIcon(buttonBackground));
        buttonNext.setHorizontalTextPosition(0);
        buttonNext.addActionListener(e -> {

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


    private String getEnteredNumber() {
        return "89117079229";
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //(370-165)/2 = 102
                g.drawImage(logo, 102, 30, null);
            }

        };

        enterPhoneNumberJPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconLock, 10+78, 10, null);

                //156 ширина

                Graphics2D twoD = (Graphics2D) g;
                twoD.setColor(Color.WHITE);
                twoD.setStroke(new BasicStroke(2));
                twoD.drawLine(78,22+10+20, 292, 22+20+10);
            }
        };
    }

    private void loadImage() {
        try {
            logo = ImageIO.read(new File("res/GUI Components/logo-mini.png"));
            iconLock = ImageIO.read(new File("res/GUI Components/icon-lock.png"));
            buttonBackground = ImageIO.read(new File("res/GUI Components/button-background.png"));
        } catch (IOException e) {
            System.out.println("Image don't load");
            e.printStackTrace();
        }
    }

}
