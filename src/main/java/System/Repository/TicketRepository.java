package System.Repository;

import System.Domain.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findTop1ByFilmLikeIgnoreCase(String id);
    Ticket findByTicketID(String id);
    List<Ticket> findAll();
}
