package com.osorio.supermarket.dto.request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
    private int userId=0;

    @NotNull
    @NotBlank(message = "Nombre es requerido")
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    //@NotBlank(message = "Edad es requerida")
    @Min(value = 1)
    private Integer age;

    @NotNull
    @NotBlank(message = "Campo es requerido")
    private String email;

    @NotNull
    @NotBlank(message = "Campo es requerido")
    private String password;
}
