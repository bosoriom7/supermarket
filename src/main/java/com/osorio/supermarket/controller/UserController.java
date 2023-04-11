package com.osorio.supermarket.controller;
import com.osorio.supermarket.dto.request.PursacheRequest;
import com.osorio.supermarket.dto.request.UserRequest;
import com.osorio.supermarket.dto.response.PursacheResponse;
import com.osorio.supermarket.dto.response.UserResponse;
import com.osorio.supermarket.entity.User;
import com.osorio.supermarket.exception.UserNotFoundException;
import com.osorio.supermarket.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    //Inyectando la interfaz al controller
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping
    public ResponseEntity<List<UserResponse>>getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<Optional<UserResponse>> getUserById(@PathVariable("user-id")int userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse>saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("user-id") int userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUserById(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.updateUserById(userRequest), HttpStatus.OK);
    }

    /*
        @DeleteMapping("/{product-id}")
    public ResponseEntity<Void>deleteProductBId(@PathVariable("product-id") int productId){
        try{
            productService.deleteProductById(productId);
        }catch (ProductNoFoundException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
     */

}
