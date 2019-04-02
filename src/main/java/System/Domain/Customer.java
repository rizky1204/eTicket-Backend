package System.Domain;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@DynamicUpdate
@Table(name = "CUSTOMER")
public class Customer extends Base {

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "email")
    private String email;
}
