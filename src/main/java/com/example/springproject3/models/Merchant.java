package com.example.springproject3.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotNull(message = "Id can not null")
    //@Size(min = 3)
    private int id;
    @NotEmpty(message = "Name Can not be empty")
    @Size(min = 3)
    private String name;

}
