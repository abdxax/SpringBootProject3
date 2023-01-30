package com.example.springproject3.controllers;

import com.example.springproject3.models.Merchant;
import com.example.springproject3.service.MerchantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping("/getAll")
    public ArrayList<Merchant> getAll(){
        return merchantService.getAll();
    }
   @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String msg =errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(msg);
        }
        merchantService.addItem(merchant);
      return  ResponseEntity.status(200).body(merchant);
    }
    @PutMapping("/updateItem/{id}")
    public ResponseEntity updateMerc(@PathVariable int id,@RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        boolean res=merchantService.updateItem(id,merchant);
        if(!res){
            return ResponseEntity.status(400).body("Error");
        }
        return ResponseEntity.status(200).body(merchant);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity deleteItem(@PathVariable int id){
        boolean res=merchantService.deleteItem(id);
        if(!res){
            ResponseEntity.status(400).body("Delete error");
        }
        return ResponseEntity.status(200).body("Delete done");
    }


}
