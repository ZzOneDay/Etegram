import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AuthorizationFormRegistration {
    private JButton Logo;
    private JTextPane TextPainPleaseTipeYourNumber;
    private JButton buttonContinue;
    private JTextField textFieldRegistrationName;
    private JTextField textFieldRegistrationFamily;
    private JPanel rootPanel;

    public AuthorizationFormRegistration()
    {
        setTextFieldHelp(textFieldRegistrationName, textFieldRegistrationName.getText());
        setTextFieldHelp(textFieldRegistrationFamily, textFieldRegistrationFamily.getText());
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
    }

    //registrashion

    //testTextField-True

    //changeFormToChat


    private void setTextFieldHelp (JTextField jTextField, String string)
    {
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (jTextField.getText().equals(string))
                {jTextField.setText("");}
            }
        });
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (jTextField.getText().length() == 0) {
                    jTextField.setText(string);
                }
            }
        });
    }



    public JPanel getRoolPanel() {
        return rootPanel;
    }
}
