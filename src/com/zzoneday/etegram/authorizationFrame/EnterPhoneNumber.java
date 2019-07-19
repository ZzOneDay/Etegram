package com.zzoneday.etegram.authorizationFrame;

import com.zzoneday.etegram.CustomFont;
import com.zzoneday.etegram.Education;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnterPhoneNumber implements authorization {
    private JPanel rootPanel;
    JPanel logoPanel;
    JPanel enterPhoneNumberJPanel;
    JPanel buttonJPanel;

    private JLabel textPleaseTypeNumber;
    private JTextField enteredNumberInField;
    private JLabel numberOne;
    private JButton buttonNext;

    private BufferedImage logo;
    private BufferedImage iconPhone;
    private BufferedImage buttonBackground;

//    static String yourNumber;


    public EnterPhoneNumber() {
        loadImage();

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        textPleaseTypeNumber.setText("<html><center>Введите код страны и номер<br>вашего мобильного телефона<center></html>");
        textPleaseTypeNumber.setFont(CustomFont.getCustomFont("OpenSansRegular", 16f));
        textPleaseTypeNumber.setForeground(Color.WHITE);

        numberOne.setFont(CustomFont.getCustomFont("OpenSansRegular", 34f));
        numberOne.setForeground(Color.white);
        enteredNumberInField.setBackground(new Color(0, 0, 0, 0));
        enteredNumberInField.setFont(CustomFont.getCustomFont("OpenSansRegular", 34f));
        enteredNumberInField.setForeground(Color.white);
        enteredNumberInField.setBorder(null);


        buttonNext.setText("ПРОДОЛЖИТЬ");
        buttonNext.setFont(CustomFont.getCustomFont("OpenSansRegular", 20f));
        buttonNext.setForeground(Color.WHITE);

        buttonNext.setIcon(new ImageIcon(buttonBackground));
        buttonNext.setHorizontalTextPosition(0);


        buttonNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("click");
                if (Education.workInOnline) {
                    //Боевой режим
                    if (Education.getResultUserIsRegistered(getEnteredNumber())) {
                        try {
                            Education.sentCodeToThisNumber(getEnteredNumber());
                        } catch (IOException e1) {
                            System.out.println("Не удалось отправить номер");
                            e1.printStackTrace();
                        }
                        EnterCode authorizationFormEnterSMSCode = new EnterCode(getEnteredNumber());
                        Education.setNextJPanelInMainJFrame(authorizationFormEnterSMSCode.getRootPanel());
                    } else {
                        Registration authorizationFormRegistration = new Registration(getEnteredNumber());
                        Education.setNextJPanelInMainJFrame(authorizationFormRegistration.getRootPanel());
                    }
                } else {
                    //Режим отладки
                    if (getEnteredNumber().length() == 2) //+7
                    {
                        System.out.println("Длинна строчки с кодом" + getEnteredNumber().length());
                        Registration authorizationFormRegistration = new Registration(getEnteredNumber());
                        Education.setNextJPanelInMainJFrame(authorizationFormRegistration.getRootPanel());
                    } else {
                        EnterCode authorizationFormEnterSMSCode = new EnterCode(getEnteredNumber());
                        Education.setNextJPanelInMainJFrame(authorizationFormEnterSMSCode.getRootPanel());
                        System.out.println("Указан номер: " + getEnteredNumber()); //Пишет номер из введеной строчки
                        System.out.println("Переход в следующее в окно: Ввод кода");
                    }
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    //Получить номер из поля ввода
    private String getEnteredNumber() {
        return "+7" + enteredNumberInField.getText();
    }

    //Внешний вид
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
                twoD.drawLine(0, 22 + 10 + 20, 370, 22 + 20 + 10);
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

