package exceptionsAndValidations.exceptions;

import lombok.Data;

@Data
public class RequestException extends RuntimeException{
    //Se puede propagar algún mensaje de error
    private String code;

    public RequestException(String code,String message) {

        super(message);
        code = code;
    }
}
