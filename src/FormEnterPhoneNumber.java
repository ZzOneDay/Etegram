import javax.swing.*;

public class FormEnterPhoneNumber {
    private JPanel rootPanel;
    private JButton button1;
    private JTextPane TextPainPleaseTipeYourNumber;
    private JButton button2;
    private JTextArea a7TextArea;
    private JTextField yourNumberField;

    public FormEnterPhoneNumber ()
    {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
    }

    public JPanel getRootPanelFormEnterPhoneNumber() {
        return rootPanel;
    }
}
