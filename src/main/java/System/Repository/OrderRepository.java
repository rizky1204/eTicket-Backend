package System.Repository;

import System.Domain.Customer;
import System.Domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findByCustomerId(Integer id);

}
