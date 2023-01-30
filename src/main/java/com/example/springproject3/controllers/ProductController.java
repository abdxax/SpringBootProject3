package com.example.springproject3.controllers;

import com.example.springproject3.models.Product;
import com.example.springproject3.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    ArrayList<Product> p=new ArrayList<>();

    @GetMapping("/getAll")
    public ArrayList<Product> getAll(){
        return  productService.getAll();
    }
    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody @Valid Product product,Errors errors) {
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        productService.addProducr(product);

        return ResponseEntity.status(200).body(product);
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity updateProduct(@PathVariable int id,@RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        boolean resul=productService.updateProduct(id,product);
        if(!resul){
            return ResponseEntity.status(400).body("Error");
        }
        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        boolean res=productService.removeProducr(id);
        if(!res){
            return ResponseEntity.status(400).body("Eroor");
        }
        return ResponseEntity.status(200).body("Done Delete");
    }
}
