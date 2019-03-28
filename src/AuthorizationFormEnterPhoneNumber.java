import javax.swing.*;
import java.io.IOException;

public class AuthorizationFormEnterPhoneNumber extends Loader {
    private JPanel rootPanel;
    JButton Logo;
    JTextPane TextPainPleaseTypeYourNumber;
    JButton LogoPhone;
    private JTextArea textAreaFirstCharNumber;
    private JTextField yourNumberField;
    private JButton buttonContinue;

    static String yourNumber;


    AuthorizationFormEnterPhoneNumber() {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        buttonContinue.addActionListener(e -> {
            try {
                checkedRegisteredUserByPhone(getYourNumber());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (userRegistered) {
                //changeForm (sendSmS)
                try {
                    System.out.println("MyNumber" + getYourNumber());
                    sentCodeToThisNumber(getYourNumber());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("userRegistered" + userRegistered);
                AuthorizationFormEnterSMSCode authorizationFormEnterSMSCode = new AuthorizationFormEnterSMSCode();
                decoration.setContentPanel(authorizationFormEnterSMSCode.getRootPanel());

            } else {
                //changeForm (registering)
                System.out.println("userRegistered" + userRegistered);
                AuthorizationFormRegistration authorizationFormRegistration = new AuthorizationFormRegistration();
                decoration.setContentPanel(authorizationFormRegistration.getRootPanel());
            }
            //Должно работать,
//                try {
//                    checkedRegisteredUserByPhone(getYourNumber());
//                sentCodeToThisNumber(getYourNumber());
            //                    AuthorizationFormEnterSMSCode authorizationFormEnterSMSCode = new AuthorizationFormEnterSMSCode();
//                    decoration.setContentPanel(authorizationFormEnterSMSCode.getRootPanel());
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                    //changeForm (registering)
//                    System.out.println("userRegistered" + userRegistered);
//                    AuthorizationFormRegistration authorizationFormRegistration = new AuthorizationFormRegistration();
//                    decoration.setContentPanel(authorizationFormRegistration.getRootPanel());
//                }

        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private String getYourNumber() {
        return textAreaFirstCharNumber.getText() + yourNumberField.getText();
    }
}
