package com.example.practica.model;
import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class User {
    
    @NotNull
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull
    @NotBlank(message = "El apellido no puede estar vacío")
    private String lastName;

    @NotNull
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String email;

    @Size(min = 9, max = 12, message = "El teléfono debe tener entre 10 y 12 caracteres")
    private String phone;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechNac;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String address;
}
