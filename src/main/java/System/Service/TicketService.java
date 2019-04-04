package System.Service;

import System.Domain.Ticket;
import System.Exception.EticketException;
import System.Repository.TicketRepository;
import System.Utils.DateUtils;
import System.Vo.TicketVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public TicketVO searchTiket(String id){
        if(StringUtils.isEmpty(id)) throw new EticketException("id can not be null");
        String film =  "%" + id + "%";
        Ticket ticket = ticketRepository.findTop1ByFilmLikeIgnoreCase(film);
        if(ticket == null) {
            throw new EticketException("Ticket not found");
        }
        String dateNow = DateUtils.dateToString(new Date() , "HHMM");
        Integer result = ticket.getFinishTime() - Integer.valueOf(dateNow);

         if(result < 0){
            throw new EticketException("The film is finished");
        }

        StringBuilder strStart = new StringBuilder(String.valueOf(ticket.getStartTime()));
        strStart.insert(2, ':');
        StringBuilder strFinish = new StringBuilder(String.valueOf(ticket.getFinishTime()));
        strFinish.insert(2, ':');

        TicketVO ticketVO = new TicketVO();
        ticketVO.setFilm(ticket.getFilm());
        ticketVO.setTicketId(ticket.getTicketID());
        ticketVO.setFinishTime(strStart.toString());
        ticketVO.setStartTime(strFinish.toString());

        return ticketVO;
    }

}
