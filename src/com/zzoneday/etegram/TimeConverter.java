package com.zzoneday.etegram;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {
    public String getTimeByTimeConverter(long dateIn) {
        long dateNowInMillis = new Date().getTime();
        long dateInMillis = dateIn * 1000;
        long dateInMillisYesterday = dateNowInMillis - 86400000;

        Date date = new Date(dateInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");

        String stringTime;

        if ((dateNowInMillis - dateInMillis) < 3600000)
        //Меньше часа
        {
            if ((dateNowInMillis - dateInMillis) < 1000 * 60)
            //Меньше минуты
            {
                stringTime = (dateNowInMillis - dateInMillis) / (1000 * 60 * 60) + " сек";
            } else stringTime = (dateNowInMillis - dateInMillis) / (1000 * 60) + " мин";
        } else if (dateFormat.format(dateInMillis).equals(dateFormat.format(dateNowInMillis))) {
            //Если Дата совпадает с Датой Сегодня, то будет написано "Сегодня"
            stringTime = "Сегодня";
        } else if (dateFormat.format(dateInMillis).equals(dateFormat.format(dateInMillisYesterday))) {
            //Если Дата совпадает с Датой Вчера, то будет написано "Вчера"
            stringTime = "Вчера";
        }
        else {
            //Не сегодня, то указывается дата
            stringTime = dateFormat.format(date);
        }

        return stringTime;
    }
}
