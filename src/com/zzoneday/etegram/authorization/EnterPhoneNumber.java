package com.zzoneday.etegram.authorization;

import com.zzoneday.etegram.Education;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterPhoneNumber implements authorization {
    private JPanel rootPanel;
    private JTextArea textAreaFirstCharNumber;
    private JTextField yourNumberField;
    JPanel logoPanel;
    private JLabel textPleaseTypeNumber;
    private JPanel enterPhoneNumberJPanel;
    private JTextField textField1;
    private JLabel numberOne;
    private JPanel buttonJPanel;
    private JButton buttonNext;

    private BufferedImage logo;
    private BufferedImage iconPhone;
    private BufferedImage buttonBackground;

//    static String yourNumber;


    public EnterPhoneNumber() {
        loadImage();


        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        textPleaseTypeNumber.setText("<html><center>Введите код страны и номер<br>вашего мобильного телефона<center></html>");
        textPleaseTypeNumber.setFont(Education.getCustomFont("regular", 16f));
        textPleaseTypeNumber.setForeground(Color.WHITE);

        numberOne.setFont(Education.getCustomFont("regular", 34f));
        numberOne.setForeground(Color.white);
        textField1.setBackground(new Color(0, 0, 0, 0));
        textField1.setFont(Education.getCustomFont("regular", 34f));
        textField1.setForeground(Color.white);
        textField1.setBorder(null);


        buttonNext.setText("ПРОДОЛЖИТЬ");
        buttonNext.setFont(Education.getCustomFont("regular",20f));
        buttonNext.setForeground(Color.WHITE);

        buttonNext.setIcon(new ImageIcon(buttonBackground));
        buttonNext.setHorizontalTextPosition(0);





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
        buttonJPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("click");
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
            }});
    };


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
                g.drawImage(logo, 102, 40, null);
            }

        };

        enterPhoneNumberJPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconPhone, 10, 10, null);

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
            buttonBackground = ImageIO.read(new File("res/GUI Components/button-background.png"));
        } catch (IOException e) {
            System.out.println("Image don't load");
            e.printStackTrace();
        }
    }


}

