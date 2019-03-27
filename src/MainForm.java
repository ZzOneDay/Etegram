import ContainsForm.ContactFormInMainFrame;
import ContainsForm.MyMessageInMainFrame;

import javax.swing.*;
import java.awt.*;

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
        jPanelMessageList.setLayout(new BoxLayout(jPanelMessageList, BoxLayout.Y_AXIS));

        ContactFormInMainFrame name1 = new ContactFormInMainFrame("Pavel", "Hello kitty", "3 sec");
        ContactFormInMainFrame name2 = new ContactFormInMainFrame("Kisa", "Hello cool kityy", "12 sec");

        jPanelContactListForm.add(name1.getRootPanel());
        jPanelContactListForm.add(name2.getRootPanel());

        MyMessageInMainFrame testMy = new MyMessageInMainFrame(true,"Hello kitty, this is my messgae, give you money", "30 sec");
        MyMessageInMainFrame textYou = new MyMessageInMainFrame(false,"Sory bro, i don't have money, i can give you milk", "15 sec");
//        MyMessageInMainFrame anyText = new MyMessageInMainFrame (true, "Lol", "5 sec");

        jPanelMessageList.add(testMy.getRootPanel());
        jPanelMessageList.add(textYou.getRootPanel());
//        jPanelMessageList.add(anyText.getRootPanel());



        //планы фиганы

        jPanelContactListForm.setLayout(new BoxLayout(jPanelContactListForm, BoxLayout.Y_AXIS));
    }
}
