package com.example.springproject3.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "Id can not null")
   // @Size(min = 3)
    private int id;
    @NotNull(message = "productid Can not be empty")
    //  @Size(min = 3)
    private int productid;
    @NotNull(message = "merchantid Can not be empty")
    //@Size(min = 3)
    private int merchantid;
    @NotNull(message = "stock Can not be empty")
    @Min(10)
    private int stock;

}
