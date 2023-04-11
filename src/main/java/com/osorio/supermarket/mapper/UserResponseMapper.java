package com.osorio.supermarket.mapper;
import com.osorio.supermarket.dto.response.UserResponse;
import com.osorio.supermarket.entity.User;
import org.springframework.stereotype.Service;
import java.util.function.Function;

//ESTA CLASE SE LIGA AL DTO RESPONSE Y SE SOBREESCRIBEN SUS OBJETOS
@Service
public class UserResponseMapper implements Function<User, UserResponse> {

    @Override
    public UserResponse apply(User user) {
        return new UserResponse(user.getUserId(),user.getName(),user.getLastName(),user.getAge(),user.getEmail());
    }
}
