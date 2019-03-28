import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AuthorizationFormRegistration {
    JButton Logo;
    JTextPane TextPainPleaseTypeYourFullNName;
    JButton buttonContinue;
    private JTextField textFieldRegistrationName;
    private JTextField textFieldRegistrationFamily;
    JPanel rootPanel;

    AuthorizationFormRegistration() {
        setTextFieldHelp(textFieldRegistrationName, textFieldRegistrationName.getText());
        setTextFieldHelp(textFieldRegistrationFamily, textFieldRegistrationFamily.getText());
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
    }


    private void setTextFieldHelp(JTextField jTextField, String string) {
        jTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (jTextField.getText().equals(string)) {
                    jTextField.setText("");
                }
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


    public JPanel getRootPanel() {
        return rootPanel;
    }
}
