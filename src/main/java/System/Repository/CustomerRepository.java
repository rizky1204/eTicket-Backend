package System.Repository;

import System.Domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , Long> {
    Customer findTop1ByCustomerIdLikeIgnoreCase(String id);
    Customer findByCustomerId(String id);
    List<Customer> findAll();
}
