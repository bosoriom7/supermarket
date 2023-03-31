package com.osorio.supermarket.controller;
import com.osorio.supermarket.controller.entity.User;
import com.osorio.supermarket.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    //Inyectando el servicio al controller
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("user-id")int userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User>saveUser(@RequestBody @Valid User user){
        return new ResponseEntity<>(userService.saveUsers(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("user-id") int userId){
        System.out.println(userId);
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{user-id}")
    public ResponseEntity<User> updateUserById(@RequestBody @Valid User user, @PathVariable("user-id") int userId){
        return new ResponseEntity<>(userService.updateUserById(user,userId), HttpStatus.OK);
    }

}
