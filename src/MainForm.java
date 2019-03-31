import ContainsForm.ContactFormInMainFrame;
import ContainsForm.MyMessageInMainFrame;
import ContainsForm.YourMessageInMainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainForm extends Loader {
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

    MainForm() throws IOException {
        jPanelMessage.setLayout(new BoxLayout(jPanelMessage, BoxLayout.Y_AXIS));

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
        AllMessage.setLayout(new BoxLayout(AllMessage, BoxLayout.Y_AXIS));
        AllMessage.add(myMessageInMainFrame3.getRootPanel());
        AllMessage.add(yourMessageInMainFrame.getRootPanel());
        ListMessage.add(new JScrollPane(AllMessage), BorderLayout.CENTER);


        JPanel ContactList = new JPanel();
        ContactList.setLayout(new BoxLayout(ContactList, BoxLayout.Y_AXIS));



        for (int i = 0; i <= bridge.contactsGetContacts().size(); i++)
        {
            String firstName = bridge.contactsGetContacts().get(i).getFirstName();
            String lastName = bridge.contactsGetContacts().get(i).getLastName();
            String fullName = firstName + " " + lastName;
            String lastMessage = bridge.messagesRecievedMessages(10).get(i).getMessage();
            int lastOnline = bridge.contactsGetStatuses().get(i).getExpires();
            String stringLastOnline = lastOnline + "sec";
            boolean statusContact = bridge.contactsGetContacts().get(i).isOnline();
            ContactFormInMainFrame contact = new ContactFormInMainFrame(fullName,lastMessage,stringLastOnline,statusContact);
            ContactList.add(contact.getRootPanel()); //
        }

        jPanelContactListForm.add(new JScrollPane(ContactList),BorderLayout.CENTER);












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
