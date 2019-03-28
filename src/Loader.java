import ContainsForm.ContactFormInMainFrame;
import ContainsForm.MyMessageInMainFrame;
import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;

public class Loader {
    static JFrame jFrame = new JFrame();
    static Decoration decoration = new Decoration();
    ;

    static Boolean userRegistered;

    static TelegramApiBridge bridge;

    static AuthAuthorization authAuthorization;


    public static void main(String[] args) throws IOException {
        bridge = new TelegramApiBridge(
                "149.154.167.50:443",
                692111,
                "80b53f81bb56fd854742600678fd27ad");
//
//
//        AuthorizationFormEnterPhoneNumber formEnterPhoneNumber = new AuthorizationFormEnterPhoneNumber();


        AuthorizationFormEnterPhoneNumber authorizationFormEnterPhoneNumber = new AuthorizationFormEnterPhoneNumber();
//        AuthorizationFormEnterSMSCode AuthorizationFormEnterSMSCode = new AuthorizationFormEnterSMSCode();


        jFrame.setSize(800, 600);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        decoration.setContentPanel(authorizationFormEnterPhoneNumber.getRootPanel()); //formEnterPhoneNumber
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void checkedPhone(String string) throws IOException {
        userRegistered = false;
        System.out.println("Проверка номера:" + string);
        //проверка б номера сюда
        AuthCheckedPhone checkedPhone = bridge.authCheckPhone(string.trim().replaceAll("[^0-9]+", ""));
        userRegistered = checkedPhone.isRegistered();
        //указать бы чтобы понимать что к чему по итоге;
    }

    public void sentCode(String string) throws IOException {
        bridge.authSendCode(string.trim().replaceAll("[^0-9]+", ""));
    }

    public void AuthAuthorization (String SMSCode) throws IOException {

        bridge.authSignIn(SMSCode.trim().replaceAll("[^0-9]+", ""));
    }

    /**
     * Нужно сделать, чтобы программа, после отправки смс, переходила в Ввод СМС кода,
     * и прописать метод, авториазации, и перехода в майн окно.
     * если выебываться по максимальному, нужно сделать чтобы сбоку список появился
     * ну хуль раз уж пошло на то, то и диологи открывать
     * да в пизду, короче можно реализовать чтобы можно было отправлять кому нибудь сообщения и получать, сук работать будет
     * но ебать как криво, похуй.
     */



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

//        System.out.println("Please, type phone number for authorization");
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


}
//    public void changeForm (JPanel jPanel1, JPanel jPanel2)
//    {
////        jPanel1.setVisible(false);
//        decoration.setContentPanel(jPanel2);
////        jPanel2.setVisible(true);
//    }
