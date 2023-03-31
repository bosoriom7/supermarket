package exceptionsAndValidations.dto;

import lombok.Builder;
import lombok.Data;

//Consultar para que sirven estas etiquetas
@Data
@Builder
public class ErrorDTO {
    //Creando objeto "error"
    private String code;
    private String message;
}
