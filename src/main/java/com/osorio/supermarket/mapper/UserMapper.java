package com.osorio.supermarket.mapper;
import com.osorio.supermarket.dto.request.UserRequest;
import com.osorio.supermarket.entity.User;
import org.springframework.stereotype.Service;
import java.util.function.Function;

//ESTA CLASE SE LIGA AL DTO REQUEST Y SE SOBREESCRIBEN SUS OBJETOS
@Service
public class UserMapper implements Function<UserRequest, User> {
    @Override
    public User apply(UserRequest userRequest) {
        return new User (0, userRequest.getName(), userRequest.getLastName(), userRequest.getAge(), userRequest.getEmail(), userRequest.getPassword());
    }
}
