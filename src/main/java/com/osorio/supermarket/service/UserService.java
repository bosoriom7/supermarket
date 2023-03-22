package com.osorio.supermarket.service;

import com.osorio.supermarket.entity.User;
import com.osorio.supermarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    //Inyectando el repositorio en el servicio
    @Autowired
    private UserRepository userRepository;

    public List<User>getAllUsers(){return userRepository.findAll();}

    public User saveUsers(User user){return (User) userRepository.findAll();}

}
