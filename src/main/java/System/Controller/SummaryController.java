package System.Controller;


import System.RequestHandler.RequestHandler;
import System.Service.CustomerService;
import System.Service.SummaryService;
import System.Vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/summary")
public class SummaryController {

    @Autowired
    SummaryService summaryService;


    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseVO> getAll(){
        RequestHandler handler = new RequestHandler() {
            @Override
            public Object processRequest() {
                return summaryService.summary();
            }
        };
        return handler.getResult();
    }

}
