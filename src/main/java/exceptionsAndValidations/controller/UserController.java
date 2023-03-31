package exceptionsAndValidations.controller;

import exceptionsAndValidations.controller.entity.User;
import exceptionsAndValidations.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user){
        //Método tradicional
        if (user.getMail().equals("")||user.getMail() == null){
            //Esta RuntimeException la puedo reemplazar por la que cree (RequestException)
            throw new RuntimeException("Email is required");
        }

        //Aplicando la BusinessException
        if (user.getMail().equals("andres@gmail.com")) {

            new BusinessException("P-300","The email already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
