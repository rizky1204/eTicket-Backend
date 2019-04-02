package System.Domain;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name = "TICKET")
public class Ticket extends Base {

    @Column(name = "TICKET_ID")
    private String ticketID;

    @Column(name = "FILM")
    private String film;

    @Column(name = "Date")
    private Date date;

    @Column(name = "STARTTIME")
    private Integer startTime;

    @Column(name = "FINISHTIME")
    private Integer finishTime;

    @Column(name = "QUANTITY")
    private Integer quantity;

}
