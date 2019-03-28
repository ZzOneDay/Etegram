import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLOutput;

public class AuthorizationFormEnterSMSCode extends Loader{
    private JButton Logo;
    private JTextPane TextPainPleaseTipeYourNumber;
    private JButton LogoBlock;
    private JButton buttonContinue;
    private JPanel rootPanel;
    private JTextArea textAreaYouNumberString;
    private JPasswordField passwordField1;

    AuthorizationFormEnterSMSCode ()
    {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        textAreaYouNumberString.setText(AuthorizationFormEnterPhoneNumber.yourNumber);
        buttonContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean smsCodeTrue = false;

                String password = String.valueOf(passwordField1.getPassword());


                try {
                    //Вводим код чтобы авторизоваться
                    AuthAuthorization(password);
                    System.out.println("go to main");
                    MainForm mainForm = new MainForm();
                    decoration.setContentPanel(mainForm.getRootPanel());

                } catch (IOException e1) {
                    System.out.println("Код неверный");
                    e1.printStackTrace();
                }

                System.out.println("SMS CODE BY STRING " + password );
                System.out.println("smsCodeTrue " + smsCodeTrue);

//                if (smsCodeTrue)
//                {
//                    System.out.println("go to main");
//                    MainForm mainForm = new MainForm();
//                    decoration.setContentPanel(mainForm.getRootPanel());
//                }
//                else
//                    System.out.println("Код неверный");

            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
