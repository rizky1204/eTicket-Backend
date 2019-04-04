package System.Utils;

import System.Domain.Customer;
import System.Domain.Ticket;
import System.Repository.CustomerRepository;
import System.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InitDb {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TicketRepository ticketRepository;

    @PostConstruct
    public void init(){

        String System = "System";

        ArrayList customerName = new ArrayList<>();
        customerName.add("Rizky Romadon");
        customerName.add("Lutfi Husaini");
        customerName.add("Ramdani Dwi");
        customerName.add("Eki Prabitra");

        ArrayList customerId = new ArrayList<>();
        customerId.add("RR001");
        customerId.add("LH002");
        customerId.add("RD003");
        customerId.add("EK004");

        ArrayList customerEmail = new ArrayList<>();
        customerEmail.add("rizky.romadon7@gmail.com");
        customerEmail.add("lutfi.husaini23@gmail.com");
        customerEmail.add("ramdani.dwi@gmail.com");
        customerEmail.add("eki.pra27@gmail.com");

        ArrayList customerPhone = new ArrayList<>();
        customerPhone.add("081218923848");
        customerPhone.add("083885238484");
        customerPhone.add("08979190598");
        customerPhone.add("081311695669");

        List<Customer> customerList = customerRepository.findAll();
        if(customerList.isEmpty()){
            for(int i=0; i<customerId.size(); i++){
                Customer customer =  new Customer();
                customer.setName(String.valueOf(customerName.get(i)));
                customer.setCustomerId(String.valueOf(customerId.get(i)));
                customer.setEmail(String.valueOf(customerEmail.get(i)));
                customer.setPhone(String.valueOf(customerPhone.get(i)));
                customer.setCreatedBy(System);
                customer.setLastModifiedBy(System);
                customerRepository.save(customer);

            }
        }


        ArrayList ticketId = new ArrayList<>();
        ticketId.add("TKWWBK");

        ArrayList film = new ArrayList<>();
        film.add("The Kid Who Would Be King");

        ArrayList startTime = new ArrayList<>();
        startTime.add("2100");

        ArrayList finishTime = new ArrayList<>();
        finishTime.add("2200");

        ArrayList quantity = new ArrayList<>();
        quantity.add("100");

        ArrayList date = new ArrayList<>();
        date.add(new Date());

        List<Ticket> ticketList = ticketRepository.findAll();
        if(ticketList.isEmpty()){
            for(int i=0; i<ticketId.size(); i++){
                Ticket ticket = new Ticket();
                ticket.setCreatedBy(System);
                ticket.setLastModifiedBy(System);
                ticket.setFilm(String.valueOf(film.get(i)));
                ticket.setStartTime(Integer.valueOf(String.valueOf(startTime.get(i))));
                ticket.setFinishTime(Integer.valueOf(String.valueOf(finishTime.get(i))));
                ticket.setQuantity(Integer.valueOf(String.valueOf(quantity.get(i))));
                ticket.setDate((Date) date.get(i));
                ticket.setTicketID(String.valueOf(ticketId.get(i)));
                ticketRepository.save(ticket);

            }
        }


    }


}
