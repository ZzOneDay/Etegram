package ContainsForm;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.BorderLayout.EAST;
import static java.awt.Component.LEFT_ALIGNMENT;
import static java.awt.Component.RIGHT_ALIGNMENT;

public class MyMessageInMainFrame {
    private JPanel rootPanel;
    private JButton ImageMessageDown;
    private JButton ImageMessageRigth;
    private JButton ImageMessageUp;
    private JTextPane textPaneMyMessage;
    private JButton ImageMessageLeft;
    private JTextArea textAreaMyTimeMessage;
    private JPanel messagePanel;
    private JPanel panelTimeMessage;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    /**
     * Здесь была попытка реальзиовать Едииную форму, которая
     * меняется в зависимости от того кто шлет мессадже, в будущем реализовано просто два фрема, мой и его.
     */

    public MyMessageInMainFrame(String textMessage, String timeMessage)
    {
        textPaneMyMessage.setText(textMessage);
        textAreaMyTimeMessage.setText(timeMessage);
    }
    public String getTextMessage ()
    {
        return textPaneMyMessage.getText();
    }
}
