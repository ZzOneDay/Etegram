package com.zzoneday.etegram;

import com.zzoneday.etegram.authorization.EnterPhoneNumber;
import com.zzoneday.etegram.main.MainForm;
import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthCheckedPhone;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Education {

    static private TelegramApiBridge bridge;
    static private JFrame jFrame;
    private static Decoration decoration;


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

        jFrame = new JFrame();
        decoration = new Decoration(jFrame);
        EnterPhoneNumber authorizationFormEnterPhoneNumber = new EnterPhoneNumber();

        jFrame.setSize(800, 600);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        //Сделает видимым лого, если авторизация ок то загрузит уже окно ввода, декарация перерисовывает
        startTelegramApiBridge();
        decoration.setContentPanel(authorizationFormEnterPhoneNumber.getRootPanel());

    }

    static public void startTestProgram() {

        jFrame = new JFrame();
        decoration = new Decoration(jFrame);
        MainForm mainForm = new MainForm();

        jFrame.setSize(800, 600);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        //Сделает видимым лого, если авторизация ок то загрузит уже окно ввода, декарация перерисовывает
        decoration.setContentPanel(mainForm.getRootPanel());

    }

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

    static private String cleanStringToNumber(String string)
    {
        return string.trim().replaceAll("[^0-9]+", "");
    }

}
