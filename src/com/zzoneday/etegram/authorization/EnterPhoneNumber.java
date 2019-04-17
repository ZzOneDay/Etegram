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
    JButton LogoPhone;
    private JTextArea textAreaFirstCharNumber;
    private JTextField yourNumberField;
    private JButton buttonContinue;
    JPanel logoPanel;
    private JLabel textPleaseTypeYourNumber;

    private BufferedImage logo;
    Font font;

//    static String yourNumber;


    public EnterPhoneNumber() {
        textPleaseTypeYourNumber.setText(getTextStartFrame());
        textPleaseTypeYourNumber.setForeground(Color.WHITE);
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        buttonContinue.addActionListener(e -> {
            if (Education.getResultUserIsRegistered(getEnteredNumber())) {
                try {
                    Education.sentCodeToThisNumber(getEnteredNumber());
                } catch (IOException e1) {
                    System.out.println("Не удалось отправить номер");
                    e1.printStackTrace();
                }
                EnterCode authorizationFormEnterSMSCode = new EnterCode();
                Education.setNextJPanelInMainJFrame(authorizationFormEnterSMSCode.getRootPanel());

            } else {
                Registration authorizationFormRegistration = new Registration();
                Education.setNextJPanelInMainJFrame(authorizationFormRegistration.getRootPanel());
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

    private String getTextStartFrame()
    {
        return "Введите код страны и номер\n" +
                "вашего мобильного телефона";
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        logoPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    logo = ImageIO.read(new File("res/GUI Components/logo.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(logo,0,40,null);
            }

        };
    }

//    static Font getFont ()
//    {
//        Font font = null;
//        try {
//            font = Font.createFont(Font.CENTER_BASELINE,new File("res/OpenSans/OpenSansLight.ttf")).deriveFont(90f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return font;
//    }
}

