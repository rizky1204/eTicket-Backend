package System.Vo;

import lombok.Data;

import java.util.Date;

@Data
public class TicketVO {
    public String TicketId;
    public String film;
    public String startTime;
    public String finishTime;
}
