package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.UserRequest;
import com.osorio.supermarket.dto.response.UserResponse;
import com.osorio.supermarket.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserResponse> getAllUsers();

    public UserResponse saveUser(UserRequest userRequest);

    public void deleteUserById(int userId);

    public UserResponse updateUserById(UserRequest userRequest);

    public Optional<UserResponse>getUserById(int userId);

}
