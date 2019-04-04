package System.Service;

import System.Repository.CustomerRepository;
import System.Repository.OrderRepository;
import System.Repository.TicketRepository;
import System.Vo.SummaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TicketRepository ticketRepository;

    public SummaryVO summary(){
        Integer countCustomer = customerRepository.countCustomer();
        Integer countOrder = orderRepository.countOrder();
        Integer countTicket = ticketRepository.countTicket();

        SummaryVO vo = new SummaryVO();
        vo.setTotalCustomer(countCustomer);
        vo.setTotalOrders(countOrder);
        vo.setTotalTicket(countTicket);

        return vo;


    }
}
