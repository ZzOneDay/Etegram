package com.zzoneday.etegram;

import java.awt.*;
import java.io.File;

public class CustomFont {
    static private Font light;
    static private Font regular;
    static private Font semiBond;

    CustomFont ()
    {
        loadCustomFont();
    }

   private void loadCustomFont() {
        //Если шрифт не прогрузиться будет обычный TimesRoman;
        //Загрузить шрифты нужно лишь раз...
        try {
            light = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSans/OpenSansLight.ttf"));
            regular = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSans/OpenSansRegular.ttf"));
            semiBond = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSans/OpenSansSemiBold.ttf"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(light);
            ge.registerFont(regular);
            ge.registerFont(semiBond);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public Font getCustomFont (String fontName, float fontSize)
    {
        Font font = new Font("TimesRoman", Font.PLAIN, 12);
        if (fontName.equals("OpenSansLight.ttf") || fontName.equals("OpenSansLight"))
        {
            font = light;
        }
        if (fontName.equals("OpenSansRegular.ttf") || fontName.equals("OpenSansRegular"))
        {
            font = regular;
        }
        if (fontName.equals("OpenSansSemiBold.ttf") || fontName.equals("OpenSansSemiBold"))
        {
            font = semiBond;
        }
        System.out.println(font.getFontName());
        return font.deriveFont(fontSize);
    }

}
