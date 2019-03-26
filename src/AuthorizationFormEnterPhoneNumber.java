import org.javagram.response.AuthCheckedPhone;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorizationFormEnterPhoneNumber extends  Loader{
    private JPanel rootPanel;
    private JButton Logo;
    private JTextPane TextPainPleaseTipeYourNumber;
    private JButton LogoPhone;
    private JTextArea textAreaFirstNumbe;
    private JTextField yourNumberField;
    private JButton buttonContinue;

    public static String yourNumber;





    public AuthorizationFormEnterPhoneNumber()
    {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userRegistered)
                {
                    //changeForm (sendSmS)
                    AuthorizationFormEnterSMSCode authorizationFormEnterSMSCode = new AuthorizationFormEnterSMSCode();
                    decoration.setContentPanel(authorizationFormEnterSMSCode.getRootPanel());
                }
                else
                    {
                        //changeForm (registering)
                        AuthorizationFormRegistration authorizationFormRegistration = new AuthorizationFormRegistration();
                        decoration.setContentPanel(authorizationFormRegistration.getRoolPanel());


                    }
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public String getYourNumber()
    {
       return yourNumberField.getText();
    }
}
