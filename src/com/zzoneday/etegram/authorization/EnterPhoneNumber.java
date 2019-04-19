package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterPhoneNumber implements authorization {
    private JPanel rootPanel;
    private JTextArea textAreaFirstCharNumber;
    private JTextField yourNumberField;
    private JButton buttonContinue;
    JPanel logoPanel;
    private JLabel textPleaseTypeNumber;
    private JPanel text;
    private JPanel enterPhoneNumber;
    private JTextField textField1;
    private JLabel numberOne;

    private BufferedImage logo;
    private BufferedImage iconPhone;

//    static String yourNumber;


    public EnterPhoneNumber() {
        loadImage();


//        textPleaseTypeYourNumber.setForeground(Color.WHITE);
        BoxLayout boxLayout = new BoxLayout(rootPanel, BoxLayout.Y_AXIS);
        rootPanel.setLayout(boxLayout);
        textPleaseTypeNumber.setText("<html><center>Введите код страны и номер<br>вашего мобильного телефона<center></html>");
        textPleaseTypeNumber.setFont(Education.getCustomFont("regular", 16f));
        textPleaseTypeNumber.setForeground(Color.WHITE);

        numberOne.setFont(Education.getCustomFont("regular", 34));
        numberOne.setForeground(Color.white);
        textField1.setBackground(new Color(0, 0, 0, 0));
        textField1.setFont(Education.getCustomFont("regular", 34f));
        textField1.setForeground(Color.white);
        textField1.setBorder(null);
//        textPanePleaseTypeYourNumber.setText("Введите код страны и номер\nвашего мобильного телефона");
//        textPanePleaseTypeYourNumber.setBackground(Color.WHITE);
//        buttonContinue.addActionListener(e -> {
//            if (Education.getResultUserIsRegistered(getEnteredNumber())) {
//                try {
//                    Education.sentCodeToThisNumber(getEnteredNumber());
//                } catch (IOException e1) {
//                    System.out.println("Не удалось отправить номер");
//                    e1.printStackTrace();
//                }
//                EnterCode authorizationFormEnterSMSCode = new EnterCode();
//                Education.setNextJPanelInMainJFrame(authorizationFormEnterSMSCode.getRootPanel());
//
//            } else {
//                Registration authorizationFormRegistration = new Registration();
//                Education.setNextJPanelInMainJFrame(authorizationFormRegistration.getRootPanel());
//            }
//        });

    }


    public JPanel getRootPanel() {
        return rootPanel;
    }


    private String getEnteredNumber() {
        System.out.println(textAreaFirstCharNumber.getText() + yourNumberField.getText());
        return textAreaFirstCharNumber.getText() + yourNumberField.getText();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 0, 40, null);
            }

        };

        enterPhoneNumber = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconPhone, 5, 10, null);

                Graphics2D twoD = (Graphics2D) g;
                twoD.setColor(Color.WHITE);
                twoD.setStroke(new BasicStroke(2));
                twoD.drawLine(0,22+10+20, 370, 22+20+10);
            }
        };
    }

    private void loadImage() {
        try {
            logo = ImageIO.read(new File("res/GUI Components/logo.png"));
            iconPhone = ImageIO.read(new File("res/GUI Components/icon-phone.png"));
        } catch (IOException e) {
            System.out.println("Image don't load");
            e.printStackTrace();
        }

    }


}

