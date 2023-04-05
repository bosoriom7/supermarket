package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.UserRequest;
import com.osorio.supermarket.dto.response.UserResponse;
import com.osorio.supermarket.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers();

    public UserResponse saveUser(UserRequest userRequest);

    public User deleteUserById(int userId);

    public User updateUserById(User user, int userId);

    public Optional<User>getUserById(int userId);


}
