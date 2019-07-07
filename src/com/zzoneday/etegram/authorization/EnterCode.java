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
    private JPanel rootPanel;
    JPanel logoPanel;
    JPanel enterPhoneNumberJPanel;
    JPanel buttonJPanel;
    JPanel MainText;

    private JPasswordField passwordField1;
    private JLabel mainText;
    private JLabel textYourNumber;

    private JButton buttonNext;

    private BufferedImage logo;
    private BufferedImage iconLock;
    private BufferedImage buttonBackground;

    //Телефон пользователя в окне

    EnterCode(String enteredNumber) {
        //Основные пункты загрузки
        loadImage();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        //Основной текст
        mainText.setText(
                "<html><center>На данный номер телефона было отправлено\n SMS-сообщение с кодом подтверждения. " +
                        "Пожалуйста, введите этот код в поле ниже:<center></html>");
        mainText.setFont(Education.getCustomFont("OpenSansRegular", 14f));
        mainText.setForeground(Color.WHITE);

        //Текст номера телефона пользователя
        textYourNumber.setText(getEnteredNumberToSting(enteredNumber));
        textYourNumber.setBackground(new Color(0, 0, 0, 0));
        textYourNumber.setFont(Education.getCustomFont("OpenSansLight", 38f));
        textYourNumber.setForeground(Color.lightGray);

        //Форма для ввода кода
        passwordField1.setBackground(new Color(0, 0, 0, 0));
        passwordField1.setFont(Education.getCustomFont("OpenSansRegular", 34f));
        passwordField1.setForeground(Color.white);
        passwordField1.setBorder(null);

        //Кнопка "Продолжить" для перехода в следующее окно
        buttonNext.setText("ПРОДОЛЖИТЬ");
        buttonNext.setFont(Education.getCustomFont("OpenSansRegular", 20f));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setIcon(new ImageIcon(buttonBackground));
        buttonNext.setHorizontalTextPosition(0);
        buttonNext.addActionListener(e -> {

                    //Безопасность на высоте
                    String code = String.valueOf(passwordField1.getPassword());
                    boolean codeResult = false;


                    if (Education.getWorkStatus()) {
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
                            System.out.println("Окна пока нет)");
//                            MainForm mainForm = new MainForm();
//                            Education.setNextJPanelInMainJFrame(mainForm.getRootPanel());
                        } else {
                            JOptionPane.showMessageDialog(rootPanel, "Неверный код");
                            passwordField1.grabFocus();
                        }
                    } else {
                        //Режим отладки
                        MainForm mainForm = new MainForm();
                        Education.setNextJPanelInMainJFrame(mainForm.getRootPanel());
                        System.out.println("Указан код: " + code);
                        System.out.println("Переход в следующее окно: Главный экран");
                    }
                }
        );
    }

    private String getEnteredNumberToSting(String number)
    //9117079229 = 10 Символов
    //+79117079229 = 12 символов
    {
        String enteredNumber;
        System.out.println(number + "have length =" + number.length() );
        if (number.length() == 12) {
            String part1 = number.substring(0,2); //+7
            String part2 = " " + number.substring(2, 5);//911
            String part3 = " " + number.substring(5, 8); // 707
            String part4 = "-" + number.substring(8, 10); //92
            String part5 = "-" + number.substring(10); //29
            enteredNumber = part1 + part2 + part3 + part4 + part5;
        } else {
            enteredNumber = number;

        }
        return enteredNumber;
    }


    public JPanel getRootPanel() {
        return rootPanel;
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
                g.drawImage(iconLock, 10 + 78, 10, null);

                //156 ширина

                Graphics2D twoD = (Graphics2D) g;
                twoD.setColor(Color.WHITE);
                twoD.setStroke(new BasicStroke(2));
                twoD.drawLine(78, 22 + 10 + 20, 292, 22 + 20 + 10);
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
