package com.example.springproject3.controllers;

import com.example.springproject3.models.MerchantStock;
import com.example.springproject3.service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockContreller {
    private final MerchantStockService merchantStockService;


    @GetMapping("/getAll")
    public ArrayList<MerchantStock> getAll(){
        return merchantStockService.getAll();
    }
    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody @Valid MerchantStock merchantStock){
        merchantStockService.addItem(merchantStock);
        return ResponseEntity.status(200).body(merchantStock);
    }
    @PutMapping("/updateItem/{id}")
    public ResponseEntity updateItem(@PathVariable int id, @RequestBody @Valid MerchantStock merchantStock, Errors errors){
       if(errors.hasErrors()){
           String msg=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(msg);
       }
        boolean res=merchantStockService.update(id,merchantStock);
        if(!res){
            return ResponseEntity.status(400).body("Error");
        }
        return ResponseEntity.status(200).body(merchantStock);
    }
    @DeleteMapping("/deleteitem/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean res=merchantStockService.delete(id);
        if(!res){
            return ResponseEntity.status(400).body("Error Delete");
        }
        return ResponseEntity.status(200).body("Done Delete");
    }
}
