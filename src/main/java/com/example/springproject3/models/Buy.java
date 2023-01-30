package com.example.springproject3.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Buy {
    private int prodId;
    private int machid;
    private int userId;
    private int count;
}
