package com.example.springproject3.controllers;

import com.example.springproject3.models.Category;
import com.example.springproject3.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/getAll")
    public ArrayList<Category> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        categoryService.addCategories(category);
        return ResponseEntity.status(200).body(category);
    }
    @PutMapping("updateIte/{id}")
    public ResponseEntity updateItem(@PathVariable int id,@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(msg);
        }
        boolean result=categoryService.updateCategorie(id,category);
        if(!result){
            return ResponseEntity.status(400).body("Error ");
        }
        return ResponseEntity.status(200).body(category);
    }
    @DeleteMapping("deleteIte/{id}")
    public ResponseEntity deleteItem(@PathVariable int id){
        boolean result=categoryService.deleteCategorie(id);
        if(!result){
            return ResponseEntity.status(400).body(result);
        }
        return ResponseEntity.status(200).body("Delete Done ");
    }
}
