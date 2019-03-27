import ContainsForm.ContactFormInMainFrame;

import javax.swing.*;

public class MainForm {
    private JPanel rootPanel;
    private JButton button1;
    private JTextArea textAreaMyNameFull;
    private JButton Image;
    private JTextField строкаПоискаTextField;
    private JButton button2;
    private JPanel jPanelContactListForm;
    private JPanel jPanelMessageList;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    MainForm()
    {
        ContactFormInMainFrame name1 = new ContactFormInMainFrame("Pavel", "Hello kitty", "3 sec");
        ContactFormInMainFrame name2 = new ContactFormInMainFrame("Kisa", "Hello cool kityy", "12 sec");

        jPanelContactListForm.add(name1.getRootPanel());
        jPanelContactListForm.add(name2.getRootPanel());

        //планы фиганы

        jPanelContactListForm.setLayout(new BoxLayout(jPanelContactListForm, BoxLayout.Y_AXIS));
    }
}
