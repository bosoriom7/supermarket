package com.osorio.supermarket.controller;
import com.osorio.supermarket.entity.User;
import com.osorio.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    //Inyectando el servicio al controller
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>>getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUsers(user), HttpStatus.OK);
    }
}
