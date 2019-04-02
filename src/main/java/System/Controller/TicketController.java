package System.Controller;

import System.RequestHandler.RequestHandler;
import System.Service.TicketService;
import System.Vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/search-ticket",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseVO> getAll(@RequestParam(value = "id", required = true) String id){
        RequestHandler handler = new RequestHandler() {
            @Override
            public Object processRequest() {
                return ticketService.searchTiket(id);
            }
        };
        return handler.getResult();
    }
}
