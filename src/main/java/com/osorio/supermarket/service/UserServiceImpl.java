package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.request.UserRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.dto.response.UserResponse;
import com.osorio.supermarket.entity.Product;
import com.osorio.supermarket.entity.User;
import com.osorio.supermarket.exception.UserNotFoundException;
import com.osorio.supermarket.mapper.UserMapper;
import com.osorio.supermarket.mapper.UserResponseMapper;
import com.osorio.supermarket.repository.PursacheRepository;
import com.osorio.supermarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    //Inyectando el repositorio en el servicio
    //Se declara final cuando no nos interesa crear clases derivadas de dicha clase
    private UserRepository userRepository;
    private final String USER_NOT_FOUND_MESSAGE = "Usuario no encontrado";

    private final UserMapper userMapper;

    private final UserResponseMapper userResponseMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserResponseMapper userResponseMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @Override
    public List<UserResponse>getAllUsers(){
        return userRepository.findAll().stream().map(userResponseMapper).toList();}

        @Override
        public UserResponse saveUser(UserRequest userRequest) {
        User user = userMapper.apply(userRequest);
        User userSave = userRepository.save(user);
        return userResponseMapper.apply(userSave);
        }

    @Override
    public void deleteUserById(int userId){
        userRepository.findById(userId)
        .ifPresent(existingUser -> userRepository.deleteById(userId));
    }

    @Override
    public UserResponse updateUserById(UserRequest userRequest){
        User user = userMapper.apply(userRequest);
        return userRepository.findById(user.getUserId())
                .map(existingUser ->userRepository.save(user))
                .map(userResponseMapper)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE));
    }

    @Override
    public Optional<UserResponse> getUserById(int userId) {
        return userRepository.findById(userId)
                .map(userResponseMapper)
                .or(()->{throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);});
    }

}
