package com.example.springproject3.controllers;

import com.example.springproject3.models.Buy;
import com.example.springproject3.models.MerchantStock;
import com.example.springproject3.models.User;
import com.example.springproject3.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/getAll")
    public ArrayList<User> getAll(){
        return userService.getAll();
    }
    @PostMapping("/addUser")
    public ResponseEntity addItem(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(msg);
        }
        userService.addItem(user);
        return ResponseEntity.status(200).body(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateItem(@PathVariable int id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(msg);
        }
        boolean res=userService.updateItem(id,user);
        if(!res){
            return ResponseEntity.status(400).body("Error update");
        }
        return ResponseEntity.status(200).body(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable int id){
        boolean res=userService.deleteItem(id);
        if(!res){
            return ResponseEntity.status(400).body("Error delete");
        }
        return ResponseEntity.status(200).body("Delete Done");
    }

    @PostMapping("/addMechStack")
    public ResponseEntity addMachStock(@Valid @RequestBody MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        boolean res=userService.addMerchantStock(merchantStock);
        if(!res){
            return ResponseEntity.status(400).body("Error add some id is woring");
        }
        return ResponseEntity.status(200).body("Added Done");
    }
    @PutMapping("/buy/{id}")
    public ResponseEntity userBuy(@PathVariable int id, @RequestBody @Valid Buy buy,  Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        int reslt=userService.buyAProduct(id,buy.getProdId(),buy.getMachid(),buy.getCount());
        if(reslt==200){
           return ResponseEntity.status(200).body("Buy is done");
        } else if (reslt==400) {
            return ResponseEntity.status(400).body("any id is not correct");
        }
        else if (reslt==500){
            return ResponseEntity.status(400).body("produect id is not correct");
        } else if (reslt==600) {
            return ResponseEntity.status(400).body("the user balance is not enough");
        }
        else if (reslt==700){
            return ResponseEntity.status(400).body("the count big the stock");
        } else if (reslt==800) {
            return ResponseEntity.status(400).body("error in update");
        }
        return ResponseEntity.status(400).body(reslt);
    }

}
