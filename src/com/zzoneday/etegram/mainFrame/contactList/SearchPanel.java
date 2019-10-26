package com.zzoneday.etegram.mainFrame.contactList;

import com.zzoneday.etegram.CustomFont;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchPanel {
    private JTextField textFieldToFind;
    private JPanel rootPanel;

    private BufferedImage iconSearch;



    public SearchPanel(ScrollPane ScrollPane)
    {
        //jScroll для того чтобы в будущем показывать в нем результаты поиска
        loadImage();
//        Color color = new Color(231,231,231);
        Color color = Color.GRAY;

        textFieldToFind.setText("Поиск");
        textFieldToFind.setFont(CustomFont.getCustomFont("OpenSansRegular.ttf", 16));
        textFieldToFind.setBorder(null);
        textFieldToFind.setOpaque(false);
        textFieldToFind.setCaretColor(color); //Курсор
        textFieldToFind.setForeground(color);
        rootPanel.setBackground(Color.WHITE);
    }

    private void loadImage() {
        try {
            iconSearch = ImageIO.read(new File("res/GUI Components/icon-search.png"));
        } catch (IOException e) {
            System.out.println("Image don't load");
            e.printStackTrace();
        }
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        rootPanel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(iconSearch,25, 12,null);
            }
        };
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
