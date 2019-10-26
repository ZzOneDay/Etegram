package com.zzoneday.etegram.authorizationFrame;

import com.zzoneday.etegram.CustomFont;
import com.zzoneday.etegram.Education;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Registration {
    private JTextField textFieldRegistrationName;
    private JTextField textFieldRegistrationFamily;
    JPanel rootPanel;
    JPanel logoPanel;
    JPanel mainJPanel;

    private JLabel mainText;
    private JPanel buttonJPanel;
    private JButton buttonNext;


    private BufferedImage logo;
    private BufferedImage buttonBackground;

    Registration(String number) {

//        if (!Education.getWorkStatus()) {
//            number = "Test";
//            System.out.println("Режим отладки");
//    }

        loadImage();

        mainText.setText(
                "<html><center>Введите ваше имя и фамилию для завершения регистрации<center></html>");
        mainText.setFont(CustomFont.getCustomFont("OpenSansRegular", 14f));
        mainText.setForeground(Color.WHITE);

        textFieldRegistrationName.setFont(CustomFont.getCustomFont("OpenSansLight", 30f));
        textFieldRegistrationFamily.setFont(CustomFont.getCustomFont("OpenSansLight", 30f));

        setTextFieldHelp(textFieldRegistrationName, textFieldRegistrationName.getText());
        setTextFieldHelp(textFieldRegistrationFamily, textFieldRegistrationFamily.getText());

        textFieldRegistrationName.setBackground(new Color(0, 0, 0, 0));
        textFieldRegistrationFamily.setBackground(new Color(0, 0, 0, 0));

        textFieldRegistrationName.setForeground(Color.lightGray);
        textFieldRegistrationFamily.setForeground(Color.lightGray);

        textFieldRegistrationName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textFieldRegistrationFamily.setBorder(javax.swing.BorderFactory.createEmptyBorder());


        //Кнопка "Продолжить" для перехода в следующее окно
        buttonNext.setText("ЗАВЕРШИТЬ");
        buttonNext.setFont(CustomFont.getCustomFont("OpenSansRegular", 20f));
        buttonNext.setForeground(Color.WHITE);
        buttonNext.setIcon(new ImageIcon(buttonBackground));
        buttonNext.setHorizontalTextPosition(0);


        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 0, true);
        buttonJPanel.setBorder(border);


        buttonNext.addActionListener(e -> JOptionPane.showMessageDialog(rootPanel,
                "Отправка на регистрацию:\n" +
                        textFieldRegistrationName.getText() + "\n" +
                        textFieldRegistrationFamily.getText() + "\n" +
                        number
                , "Registration", JOptionPane.INFORMATION_MESSAGE));
    }


    private void setTextFieldHelp(JTextField jTextField, String string) {
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (jTextField.getText().equals(string)) {
                    jTextField.setText("");
                    jTextField.setForeground(Color.WHITE);
                }
            }
        });
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (jTextField.getText().length() == 0) {
                    jTextField.setText(string);
                    jTextField.setForeground(Color.gray);
                }
            }
        });
    }

//    enterPhoneNumberJPanel = new JPanel() {
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(iconLock, 10 + 78, 10, null);
//
//            //156 ширина
//
//            Graphics2D twoD = (Graphics2D) g;
//            twoD.setColor(Color.WHITE);
//            twoD.setStroke(new BasicStroke(2));
//            twoD.drawLine(78, 22 + 10 + 20, 292, 22 + 20 + 10);
//        }
//    };


    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //(240-165)/2 = 75
                g.drawImage(logo, 55, 30, null);
            }

        };
        mainJPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                Graphics2D line1 = (Graphics2D) g;
                line1.setColor(Color.WHITE);
                line1.setStroke(new BasicStroke(2));
                line1.drawLine(30, 22 + 10 + 20 + 18, 270, 22 + 20 + 10 + 18);

                Graphics2D line2 = (Graphics2D) g;
                line2.setColor(Color.WHITE);
                line2.setStroke(new BasicStroke(2));
                line2.drawLine(30, 22 + 10 + 20 + 55 + 30 + 8, 270, 22 + 20 + 10 + 55 + 30 + 8);
            }
        };
    }

    private void loadImage() {
        try {
            logo = ImageIO.read(new File("res/GUI Components/logo-mini.png"));
            buttonBackground = ImageIO.read(new File("res/GUI Components/button-background.png"));
        } catch (IOException e) {
            System.out.println("Image don't load");
            e.printStackTrace();
        }
    }
}
