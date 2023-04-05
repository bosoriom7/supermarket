package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.request.UserRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.dto.response.UserResponse;
import com.osorio.supermarket.entity.Product;
import com.osorio.supermarket.entity.User;
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

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public List<User>getAllUsers(){return userRepository.findAll();}

        @Override
        public UserResponse saveUser(UserRequest userRequest) {
        User user = new User(0, userRequest.getName(), userRequest.getLastName(), userRequest.getAge(), userRequest.getEmail(), userRequest.getPassword());
        User userSave = userRepository.save(user);
        return new UserResponse(userSave.getName(),userSave.getLastName(),userRequest.getAge(), userRequest.getEmail());
        }

    @Override
    public User deleteUserById(int userId){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            userRepository.deleteById(userId);
        }
        return null;
    }

    @Override
    public User updateUserById(User user, int userId){
        Optional<User> userToUpdate = userRepository.findById(userId);
        if (userToUpdate.isPresent()) {
            user.setUserId(userId);
            user = userRepository.save(user);
        }
        return user;
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }
}
