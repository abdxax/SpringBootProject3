package com.example.springproject3.models;

import com.example.springproject3.Validation.ValidationPrice;
import com.example.springproject3.Validation.ValidationRole;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "Id can not be empty")
    //@Size(min = 3)
    private int id;
    @NotEmpty(message = "Id can not be empty")
    @Size(min = 5)
    private String userName;
    @NotEmpty(message = "Id can not be empty")
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,}$",message = "The Password must be 6 and up char and have latter and dight ")
    private String password;
    @NotEmpty(message = "email can not be empty")
    @Email
    private String email;
    @NotEmpty(message = "role can not be empty")
    @Pattern(regexp = "Admin|Customer",message = "The role must be admin or customer")
    private String role;
    //@NotEmpty(message = "balance can not be empty")
    @ValidationPrice(message = "balance must be postive ")
    private double balance;
}
