package com.example.springproject3.service;

import com.example.springproject3.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class CategoryService {
    ArrayList<Category> categories=new ArrayList<>();

    public void addCategories(Category category){
        categories.add(category);

    }

    public ArrayList<Category> getAll(){
        return categories;
    }

    public boolean updateCategorie(int id,Category category){
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategorie(int id){
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==id){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean IsHave(int id){
        for(int i =0;i<categories.size();i++){
            if(categories.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }

}
