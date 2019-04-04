package System.Service;

import System.Domain.Customer;
import System.Exception.EticketException;
import System.Repository.CustomerRepository;
import System.Vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerVO searchCustomer(String id){
        String methodName ="searchCustomer";
        if(StringUtils.isEmpty(id)) {
            throw new EticketException("id can not be null");
        }
        String idCustomer = "%" + id + "%";
        log.info("BEGIN:{}" , methodName);
        Customer customer = customerRepository.findTop1ByCustomerIdLikeIgnoreCase(idCustomer);
        log.info(String.valueOf(customer));
        if(customer == null) throw new EticketException("Customer not found");
        CustomerVO customerVO = new CustomerVO();
        customerVO.setCustomerID(customer.getCustomerId());
        customerVO.setEmail(customer.getEmail());
        customerVO.setName(customer.getName());
        customerVO.setPhone(customer.getPhone());
        log.info("DONE:{}" , methodName);
        return customerVO;
    }


}
