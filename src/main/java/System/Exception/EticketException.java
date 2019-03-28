package System.Exception;

import System.RequestHandler.StatusCode;

public class EticketException extends RuntimeException {

    private StatusCode code = StatusCode.ERROR;

    public EticketException() {
        super();
    }

    public EticketException(String message) {
        super(message);
    }

    public EticketException(StatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }



}
