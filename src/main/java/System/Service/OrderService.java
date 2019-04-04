package System.Service;

import System.Domain.Customer;
import System.Domain.Order;
import System.Domain.Ticket;
import System.Exception.EticketException;
import System.Repository.CustomerRepository;
import System.Repository.OrderRepository;
import System.Repository.TicketRepository;
import System.Utils.OrderId;
import System.Validator.OrderValidator;
import System.Vo.AddOrderVO;
import System.Vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderVO addOrder(AddOrderVO vo){
        String methodName ="Order";
        log.debug("debug:{} vo:{}" , methodName , vo);
        String message = OrderValidator.addOrderValidate(vo);
        if(message != null) throw new EticketException(message);

        Customer customer = customerRepository.findByCustomerId(vo.getCustomerId());
        log.debug("debug:{} customer:{}" ,methodName , customer );
        if(customer == null) throw new EticketException("Customer not found");

        Ticket ticket =  ticketRepository.findByTicketID(vo.getTicketId());
        log.debug("debug:{} ticket:{}" ,methodName , ticket );
        if(ticket == null) throw new EticketException("Ticket not found");
        if(ticket.getQuantity() == 0) throw new EticketException("Ticket sold out");

        if(ticket.getQuantity() < vo.getBuy()){
            throw new EticketException("Ticket balance is not enough");
        }else{
            Integer currentQty = ticket.getQuantity()- vo.getBuy() ;
            ticket.setQuantity(currentQty);
            ticketRepository.save(ticket);
        }

        List<Order> lastOrder =  orderRepository.findAll();
        Order lastId=null;
        if(!lastOrder.isEmpty()){
             lastId = lastOrder.get(lastOrder.size() -1);
        }

        String orderId = null;
        if(!StringUtils.isEmpty(lastId)){
             orderId = OrderId.orderId
                    (ticket.getTicketID() , lastId.getId());
        }else{
            orderId = OrderId.orderId
                    (ticket.getTicketID() , 0);
        }


        Order order = new Order();
        order.setCustomer(customer);
        order.setTicket(ticket);
        order.setBuy(vo.getBuy());
        order.setOrderId(orderId);
        orderRepository.save(order);

        StringBuilder strStart = new StringBuilder(String.valueOf(ticket.getStartTime()));
        strStart.insert(2, ':');
        StringBuilder strFinish = new StringBuilder(String.valueOf(ticket.getFinishTime()));
        strFinish.insert(2, ':');

        OrderVO orderVO = new OrderVO();
        orderVO.setFilm(ticket.getFilm());
        orderVO.setStartTime(strStart.toString());
        orderVO.setFinishTime(strFinish.toString());
        orderVO.setOrderId(orderId);

        return orderVO;
    }
}
