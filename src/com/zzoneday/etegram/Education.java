package com.zzoneday.etegram;

import com.zzoneday.etegram.authorization.EnterPhoneNumber;
import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthCheckedPhone;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Education {

    static private TelegramApiBridge bridge;
    private JFrame jFrame;
    private Decoration decoration;
    protected static Education education = new Education();
    private boolean resultUserIsRegistered;


    private void startTelegramApiBridge ()
    {

        try {
            bridge = new TelegramApiBridge(
                    "149.154.167.50:443",
                    692111,
                    "80b53f81bb56fd854742600678fd27ad");
            System.out.println("Авторизация на сервере - Ок");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(getJFrame(),"Ошибка подключения к серверу",
                    "Ошибка соединения", JOptionPane.ERROR_MESSAGE);
            System.out.println("Авторизация на сервере - Ошибка");
            e.printStackTrace();
        }
    }

    public void startProgram() {

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

    public void startTestProgram() {

        jFrame = new JFrame();
        decoration = new Decoration(jFrame);
        EnterPhoneNumber authorizationFormEnterPhoneNumber = new EnterPhoneNumber();

        jFrame.setSize(800, 600);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        //Сделает видимым лого, если авторизация ок то загрузит уже окно ввода, декарация перерисовывает
        decoration.setContentPanel(authorizationFormEnterPhoneNumber.getRootPanel());

    }

    public ArrayList getContactsArrayList() throws IOException {
        return bridge.contactsGetContacts();
    }

    public void setNextJPanelInMainJFrame(JPanel jPanel)
    {
        getDecoration().setContentPanel(jPanel.getRootPane());
    }


    protected void checkedRegisteredUserByPhone(String string) {


        System.out.println("Проверка номер: "+cleanStringToNumber(string));
        resultUserIsRegistered = false;
        AuthCheckedPhone checkedPhone;
        try {
            checkedPhone = bridge.authCheckPhone(cleanStringToNumber(string));
            resultUserIsRegistered = checkedPhone.isRegistered();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sentCodeToThisNumber(String string) throws IOException {
        System.out.println("Отправка кода на номер: " + cleanStringToNumber(string));
        bridge.authSendCode(cleanStringToNumber(string));
    }

    public void authorizationUserByCode(String code) throws IOException {
        System.out.println("Отправка кода для авторизации: " + cleanStringToNumber(code));
        bridge.authSignIn(cleanStringToNumber(code));
    }

    private String cleanStringToNumber (String string)
    {
        return string.trim().replaceAll("[^0-9]+", "");
    }

    private Decoration getDecoration () {
        return decoration;
    }

    private JFrame getJFrame ()
    {
        return jFrame;
    }

    public boolean getResultUserIsRegistered ()
    {
        return resultUserIsRegistered;
    }
}
