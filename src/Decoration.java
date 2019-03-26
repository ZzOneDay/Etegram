import javax.swing.*;
import java.awt.*;

public class Decoration {
    private JButton minimizeButton;
    private JButton closeButton;
    private JPanel rootPanel;
    private JPanel titlePanel;
    private JPanel contentPanel;

    public void setContentPanel(Component component) {
        contentPanel.removeAll(); //Очищаем
        contentPanel.add(component);
        contentPanel.revalidate(); //Растягивает
        contentPanel.repaint(); //Перерисовка
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
