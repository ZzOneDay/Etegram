package com.zzoneday.etegram;

import com.zzoneday.etegram.authorization.EnterPhoneNumber;
import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthCheckedPhone;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Education {

    static private TelegramApiBridge bridge;
    static private JFrame jFrame;
    private static Decoration decoration;

    static private Font light;
    static private Font regular;
    static private Font semiBond;

    private static boolean workStatusToNormal = true; //Режим отработки = Нет

    static public boolean getWorkStatus ()
    {
        return workStatusToNormal;
    }

    static public void setWorkStatus (Boolean workStatusIsNormal)
    {
        workStatusToNormal = workStatusIsNormal;
    }


    static private void startTelegramApiBridge() {

        try {
            bridge = new TelegramApiBridge(
                    "149.154.167.50:443",
                    692111,
                    "80b53f81bb56fd854742600678fd27ad");
            System.out.println("Авторизация на сервере - Ок");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(jFrame, "Ошибка подключения к серверу",
                    "Ошибка соединения", JOptionPane.ERROR_MESSAGE);
            System.out.println("Авторизация на сервере - Ошибка");
            e.printStackTrace();
        }
    }

    static public void startProgram() {

        loadCustomFont();

        jFrame = new JFrame();
        decoration = new Decoration(jFrame);
        EnterPhoneNumber authorizationFormEnterPhoneNumber = new EnterPhoneNumber();

        jFrame.setSize(905, 630);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        //Сделает видимым лого, если авторизация ок то загрузит уже окно ввода, декарация перерисовывает
        if (getWorkStatus()) {
        startTelegramApiBridge();
        }

        decoration.setContentPanel(authorizationFormEnterPhoneNumber.getRootPanel());

    }

    //Инструменты простые

    static private String cleanStringToNumber(String string)
    {
        return string.trim().replaceAll("[^0-9]+", "");
    }

    private static void loadCustomFont() {
        //Если шрифт не прогрузиться будет обычный TimesRoman;
        try {
            //create the font to use. Specify the size!
            light = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSans/OpenSansLight.ttf"));
            regular = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSans/OpenSansRegular.ttf"));
            semiBond = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSans/OpenSansSemiBold.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(light);
            ge.registerFont(regular);
            ge.registerFont(semiBond);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Font getCustomFont (String fontName, float fontSize)
    {
        Font font = new Font("TimesRoman", Font.PLAIN, 12);
        if (fontName.equals("OpenSansLight"))
        {
            font = light;
        }
        if (fontName.equals("OpenSansRegular"))
        {
            font = regular;
        }
        if (fontName.equals("OpenSansSemiBold"))
        {
            font = semiBond;
        }
        System.out.println(font.getFontName());
        return font.deriveFont(fontSize);
    }


    //Инструменты по работе с API Bridge;

    static public ArrayList getContactsArrayList() throws IOException {
        return bridge.contactsGetContacts();
    }

    static public void setNextJPanelInMainJFrame(JPanel jPanel) {
        decoration.setContentPanel(jPanel);
    }


    static public boolean getResultUserIsRegistered(String string) {

        boolean resultUserIsRegistered = false;
        System.out.println("Проверка номер: " + cleanStringToNumber(string));
        AuthCheckedPhone checkedPhone;
        try {
            checkedPhone = bridge.authCheckPhone(cleanStringToNumber(string));
            resultUserIsRegistered = checkedPhone.isRegistered();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultUserIsRegistered;
    }


    static public void sentCodeToThisNumber(String string) throws IOException {
        System.out.println("Отправка кода на номер: " + cleanStringToNumber(string));
        bridge.authSendCode(cleanStringToNumber(string));
    }

    static public void authorizationUserByCode(String code) throws IOException {
        System.out.println("Отправка кода для авторизации: " + cleanStringToNumber(code));
        bridge.authSignIn(cleanStringToNumber(code));
    }


    }



