package com.example.springproject3.models;

import com.example.springproject3.Validation.ValidationPrice;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "Id Can not be empty")
    //@Size(min = 3)
    private int id;
    @NotEmpty(message = "Name Can not be empty")
    @Size(min = 3)
    private String name;
    @NotNull
    @Min(0)
    private double price;
    @NotEmpty(message = "categoryID Can not be empty")
    @Size(min = 3)
    private String categoryID;
}
