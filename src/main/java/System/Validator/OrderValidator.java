package System.Validator;

import System.Exception.EticketException;
import System.Vo.AddOrderVO;

public class OrderValidator {

    public static String addOrderValidate(AddOrderVO vo){
        if(vo.getCustomerId().isEmpty()) return "Ticket id can't be null";
        if(vo.getTicketId().isEmpty()) return "Customer id can't be null";
        if(vo.getBuy() == null) return "Qty can't be null";

        return null;

    }
}
