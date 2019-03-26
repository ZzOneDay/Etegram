import javax.swing.*;
import java.awt.*;

public class Decoration {
    private JButton minimizeButton;
    private JButton closeButton;
    private JPanel rootPanel;
    private JPanel contentPanel;

    Decoration() {
        closeButton.addActionListener(e -> closeApp());
        minimizeButton.addActionListener(e -> minimizeApp());
    }

    void setContentPanel(Component component) {
        contentPanel.removeAll(); //Очищаем
        contentPanel.add(component);
        contentPanel.revalidate(); //Растягивает
        contentPanel.repaint(); //Перерисовка
    }

    private void minimizeApp ()
    {
        Loader.jFrame.setState(JFrame.ICONIFIED);
    }

    private void closeApp()
    {
        Loader.jFrame.dispose();
    }




    JPanel getRootPanel() {
    return rootPanel;
}

}
