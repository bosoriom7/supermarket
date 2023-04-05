package com.osorio.supermarket.service;

import com.osorio.supermarket.entity.User;
import com.osorio.supermarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Inyectando el repositorio en el servicio
    @Autowired
    private UserRepository userRepository;

    public List<User>getAllUsers(){return userRepository.findAll();}

    public User saveUsers(User user){return (User) userRepository.save(user);}

    public User deleteUserById(int userId){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.deleteById(userId);
        }
        return null;
    }

    public User updateUserById(User user, int userId){
        Optional<User> userToUpdate = userRepository.findById(userId);
        if (userToUpdate.isPresent()) {
            user.setUserId(userId);
            user = userRepository.save(user);
        }
        return user;
    }

    public Optional<User> getUserById(int userId){
        return userRepository.findById(userId);
    }
}
