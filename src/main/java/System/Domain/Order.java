package System.Domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@Table(name = "ORDERS")
public class Order extends  Base{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKETID")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMERID")
    private Customer customer;

    @Column(name = "BUY")
    private Integer buy;

}
