package System.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderId {
    public static String orderId(String filmId , Integer id){
        String orderId = filmId + "00" + id;
        return orderId;
    }
}
