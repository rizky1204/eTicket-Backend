package System.Vo;

import lombok.Data;

@Data
public class OrderVO {
    public String orderId;
    public  String film;
    public String startTime;
    public String finishTime;
}
