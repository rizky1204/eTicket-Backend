package System.Controller;

import System.RequestHandler.RequestHandler;
import System.Service.OrderService;
import System.Vo.AddOrderVO;
import System.Vo.CustomerVO;
import System.Vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseVO> withdraw(@RequestBody AddOrderVO addOrderVO) {
        RequestHandler handler = new RequestHandler() {
            @Override
            public Object processRequest() {
                return  orderService.addOrder(addOrderVO);
            }
        };
        return handler.getResult();
    }

}
