import ContainsForm.ContactFormInMainFrame;
import ContainsForm.MyMessageInMainFrame;
import ContainsForm.YourMessageInMainFrame;

import javax.swing.*;
import java.awt.*;

public class MainForm {
    private JPanel rootPanel;
    JButton button1;
    JTextArea textAreaMyNameFull;
    JButton Image;
    JTextField TextFieldToFind;
    JButton button2;
    private JPanel jPanelContactListForm;
    private JPanel jPanelMessage;
    private JButton button3;
    private JPanel ListMessage;
    private JEditorPane MyEditorPanel;

    //Пока, здесь все очень тестово

    public JPanel getRootPanel() {
        return rootPanel;
    }

    MainForm() {
        jPanelMessage.setLayout(new BoxLayout(jPanelMessage, BoxLayout.Y_AXIS));

        ContactFormInMainFrame name1 = new ContactFormInMainFrame("Pavel", "Hello kitty", "3 sec");
        ContactFormInMainFrame name2 = new ContactFormInMainFrame("Kisa", "Hello cool kityy", "12 sec");

        jPanelContactListForm.add(name1.getRootPanel());
        jPanelContactListForm.add(name2.getRootPanel());

        MyMessageInMainFrame myMessageInMainFrame =
                new MyMessageInMainFrame("Hello my Friend, What are you Doing",
                        "40 sec ago");
        YourMessageInMainFrame yourMessageInMainFrame =
                new YourMessageInMainFrame("Hello, i create my new Elegram, this is TOP messager",
                        "10 sec ago");
        MyMessageInMainFrame myMessageInMainFrame1 =
                new MyMessageInMainFrame("Hello my Friend, What are you Doing",
                        "40 sec ago");
        MyMessageInMainFrame myMessageInMainFrame2 =
                new MyMessageInMainFrame("Hello my Friend, What are you Doing",
                        "40 sec ago");
        MyMessageInMainFrame myMessageInMainFrame3 =
                new MyMessageInMainFrame("Hello my Friend, What are you Doing",
                        "40 sec ago");


        JPanel AllMessage = new JPanel();

        AllMessage.add(myMessageInMainFrame.getRootPanel());
        AllMessage.add(myMessageInMainFrame1.getRootPanel());
        AllMessage.add(myMessageInMainFrame2.getRootPanel());
        AllMessage.add(myMessageInMainFrame3.getRootPanel());
        AllMessage.add(yourMessageInMainFrame.getRootPanel());


        AllMessage.setLayout(new BoxLayout(AllMessage, BoxLayout.Y_AXIS));

        ListMessage.add(new JScrollPane(AllMessage), BorderLayout.CENTER);


        //планы фиганы

        jPanelContactListForm.setLayout(new BoxLayout(jPanelContactListForm, BoxLayout.Y_AXIS));
        button3.addActionListener(e -> {
            MyMessageInMainFrame myText = new MyMessageInMainFrame(MyEditorPanel.getText(), "0 sec");
            AllMessage.add(myText.getRootPanel());
            System.out.println(myText.getTextMessage());
            AllMessage.repaint(); //Перерисовка
        });
    }
}
