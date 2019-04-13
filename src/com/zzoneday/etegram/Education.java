package com.zzoneday.etegram;

import com.zzoneday.etegram.authorization.AuthorizationFormEnterPhoneNumber;
import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthCheckedPhone;

import javax.swing.*;
import java.io.IOException;

public class Education {

    private TelegramApiBridge bridge;
    private JFrame jFrame;
    private Decoration decoration;


    private void startTelegramApiBridge ()
    {

        try {
            bridge = new TelegramApiBridge(
                    "149.154.167.50:443",
                    692111,
                    "80b53f81bb56fd854742600678fd27ad");
            System.out.println("Авторизация на сервере - Ок");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(getjFrame(),"Ошибка подключения к серверу",
                    "Ошибка соединения", JOptionPane.ERROR_MESSAGE);
            System.out.println("Авторизация на сервере - Ошибка");
            e.printStackTrace();
        }
    }

    public void startProgram() {

        JFrame jFrame = new JFrame();
        Decoration decoration = new Decoration(jFrame);
        AuthorizationFormEnterPhoneNumber authorizationFormEnterPhoneNumber = new AuthorizationFormEnterPhoneNumber();

        jFrame.setSize(800, 600);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        //Сделает видимым лого, если авторизация ок то загрузит уже окно ввода, декарация перерисовывает
        startTelegramApiBridge();
        decoration.setContentPanel(authorizationFormEnterPhoneNumber.getRootPanel());

    }

    public void setNextJPanelInMainJFrame(JPanel jPanel)
    {
        getDecoration().setContentPanel(jPanel.getRootPane());
    }


    public boolean checkedRegisteredUserByPhone (String string) throws IOException {
        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(cleanStringToNumber(string));
        System.out.println("Проверка номер: "+cleanStringToNumber(string));
        return checkedPhone.isRegistered();
    }


    public void sentCodeToThisNumber(String string) throws IOException {
        System.out.println("Отправка кода на номер: " + cleanStringToNumber(string));
        bridge.authSendCode(cleanStringToNumber(string));
    }

    void authAuthorizationCode(String code) throws IOException {
        System.out.println("Отправка кода для авторизации: " + cleanStringToNumber(code));
        bridge.authSignIn(cleanStringToNumber(code));
    }

    private String cleanStringToNumber (String string)
    {
        return string.trim().replaceAll("[^0-9]+", "");
    }

    Decoration getDecoration ()
    {
        return decoration;
    }
    JFrame getjFrame ()
    {
        return jFrame;
    }


}
