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


        JPanel AllMessage = new JPanel();
        AllMessage.setLayout(new BoxLayout(AllMessage, BoxLayout.Y_AXIS));
        AllMessage.add(myMessageInMainFrame.getRootPanel());
        AllMessage.add(yourMessageInMainFrame.getRootPanel());
        ListMessage.add(new JScrollPane(AllMessage), BorderLayout.CENTER);


        JPanel ContactList = new JPanel();
        ContactList.setLayout(new BoxLayout(ContactList, BoxLayout.Y_AXIS));
        ArrayList contactsList = bridge.contactsGetContacts();
//        ArrayList lastMessageList = bridge.messagesRecievedMessages(10);

        String one = contactsList.get(0).toString();
        System.out.println(one);


        int i = 0;
        while (i < contactsList.size()) {

            String fullName = contactsList.get(i).toString();
            String lastMessage = "Hello";
//            int lastOnline = bridge.contactsGetStatuses().get(i).getExpires();
            String stringLastOnline = "sec";
//            boolean statusContact = bridge.contactsGetContacts().get(i).isOnline();
            ContactFormInMainFrame contact = new ContactFormInMainFrame(fullName,lastMessage,stringLastOnline,true);
            ContactList.add(contact.getRootPanel()); //
            System.out.println("Create contactJPanel " + fullName);
            i++;
        }

        jPanelContactListForm.add(new JScrollPane(ContactList),BorderLayout.CENTER);
        jPanelContactListForm.setLayout(new BoxLayout(jPanelContactListForm, BoxLayout.Y_AXIS));


        button3.addActionListener(e -> {
            MyMessageInMainFrame myText = new MyMessageInMainFrame(MyEditorPanel.getText(), "0 sec");
            AllMessage.add(myText.getRootPanel());
            System.out.println(myText.getTextMessage());
            AllMessage.repaint(); //Перерисовка
        });



    }
}
