package com.example.springproject3.service;

import com.example.springproject3.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products=new ArrayList<>();

    public ArrayList<Product> getAll(){
        return products;
    }

    public boolean updateProduct(int id,Product product){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.set(i,product);
                return true;
            }
        }
        return  false;
    }

    public boolean removeProducr(int id){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                products.remove(i);
                return true;
            }
        }
        return  false;
    }

    public void addProducr(Product product){
        products.add(product);

    }
    public boolean IsHave(int id){
        for(int i =0;i<products.size();i++){
            if(products.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }

    public Product getPrice(int id){
        for(int i =0;i<products.size();i++){
            if(products.get(i).getId()==id){
                return products.get(i);
            }
        }
        return null;
    }
}
