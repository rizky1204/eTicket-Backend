package System.Utils;

import System.Exception.EticketException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String result = dateFormat.format(date);
        return result;
    }

    public static Date stringToDate(String date, String format) {

        Date result;
        DateFormat dateFormat = new SimpleDateFormat(format);

        try {
            result = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new EticketException("Format Date " + "HH:MM");
        }

        return result;

    }
}
