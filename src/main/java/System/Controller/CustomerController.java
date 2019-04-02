package System.Controller;


import System.RequestHandler.RequestHandler;
import System.Service.CustomerService;
import System.Vo.CustomerVO;
import System.Vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "/search-customer",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseVO> getAll(@RequestParam(value = "id", required = true) String id){
        RequestHandler handler = new RequestHandler() {
            @Override
            public Object processRequest() {
                return customerService.searchCustomer(id);
            }
        };
        return handler.getResult();
    }

}
