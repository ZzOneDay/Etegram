import Frame.AuthorizationFormEnterPhoneNumber;
import Frame.Decoration;

import javax.swing.*;
import java.io.IOException;

public class Loader
{
    public static JFrame jFrame = new JFrame();
    public static void main(String[] args) throws IOException
    {
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


        Decoration decoration = new Decoration();
        AuthorizationFormEnterPhoneNumber formEnterPhoneNumber = new AuthorizationFormEnterPhoneNumber();


        jFrame.setSize(800,600);
        jFrame.setUndecorated(true);
        jFrame.setContentPane(decoration.getRootPanel());
        decoration.setContentPanel(formEnterPhoneNumber.getRootPanelFormEnterPhoneNumber());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);


        }
    }
