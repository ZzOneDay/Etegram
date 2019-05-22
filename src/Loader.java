import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.authorization.EnterPhoneNumber;

import javax.swing.*;
import java.awt.*;

public class Loader {

    static Boolean workToTest = false;

    public static void main(String[] args) {

        Frame test = new Frame();
        JPanel jPanel = new JPanel();

        int newEnter = JOptionPane.showConfirmDialog(jPanel,"Войти в обычном рабочем режиме?", "Меню входа в приложение", JOptionPane.YES_NO_OPTION);
        if (newEnter == JOptionPane.NO_OPTION)
        {
            Education.setWorkStatus(false);
            //false - режим разрабочика; Изначально задано true - обычная работа приложения
        }

        Education.startProgram();
    }

    public boolean getWorkStatus ()
    {
        return workToTest;
    }
}


//
//    ---------------------------------------------------------------
//        System.out.println(checkedPhone.isRegistered());
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Please, type phone number: ");
//
//        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443",692111, "80b53f81bb56fd854742600678fd27ad");

//        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(reader.readLine().trim().replaceAll("[^0-9]+", ""));

//        System.out.println(checkedPhone.isRegistered());

//        System.out.println("Please, type phone number for aasasuthorization");
//        AuthSentCode sentCode = bridge.authSendCode(reader.readLine().trim().replaceAll("[^0-9]+", ""));
//        System.out.println(sentCode.isRegistered());
//        System.out.println("Please, type code thom SMS-message");
//        AuthAuthorization authAuthorization = bridge.authSignIn(reader.readLine().trim().replaceAll("[^0-9]+", ""));
//        System.out.println(authAuthorization);
//        System.out.println(authAuthorization.getUser());
//
//
//        ArrayList contactsList = bridge.contactsGetContacts();
//        for (int i = 0; i < (contactsList.size() - 1); i++) {
//            System.out.println(contactsList.get(i));
//
//    public void changeForm (JPanel jPanel1, JPanel jPanel2)
//    {
////        jPanel1.setVisible(false);
//        decoration.setContentPanel(jPanel2);
////        jPanel2.setVisible(true);
//    }
