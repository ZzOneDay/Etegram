import com.zzoneday.etegram.Decoration;
import com.zzoneday.etegram.Education;
import com.zzoneday.etegram.authorization.EnterPhoneNumber;
import com.zzoneday.etegram.main.UserAvatar;
import com.zzoneday.etegram.main.contactList.Contact;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Loader {

    public static void main(String[] args) {

        int newEnter = JOptionPane.showConfirmDialog(new JPanel(),"Войти в обычном рабочем режиме?",
                "Меню входа в приложение", JOptionPane.YES_NO_OPTION);
        if (newEnter == JOptionPane.NO_OPTION)
        {
            Education.setWorkStatus(false);
            //false - режим разрабочика; Изначально задано true - обычная работа приложения
        }

        //Запуск основного кода программы
        Education.startProgram();

        JFrame jFrame = new JFrame();
        Contact contact = new Contact
                ("Павел Новиков",
                        "Как твои дела, Котик?",
                        "9 сек",
                        "res/User41.png",
                        true);

        jFrame.setSize(905, 630);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(contact.getRootPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
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
