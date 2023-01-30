package com.example.springproject3.service;

import com.example.springproject3.models.Merchant;
import com.example.springproject3.models.MerchantStock;
import com.example.springproject3.models.Product;
import com.example.springproject3.models.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> users=new ArrayList<>();
    private final ProductService productService;
    private final MerchantStockService merchantStockService;
    public ArrayList<User> getAll(){
        return users;
    }
    public void addItem(User user){
        users.add(user);

    }

    public boolean updateItem(int id, User user){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteItem(int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean IsHave(int id){
        for(int i =0;i<users.size();i++){
            if(users.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }
    public User getUser(int id){
        for(int i =0;i<users.size();i++){
            if(users.get(i).getId()==id){
                return users.get(i);
            }
        }
        return null;
    }

    public boolean addMerchantStock(MerchantStock merchantStock){
        if(productService.IsHave(merchantStock.getProductid())&&merchantStockService.IsHave(merchantStock.getMerchantid())){
         // merchantService.addItem(new Merchant(merchantService.merchants.size()+1,""));
            merchantStockService.addItem(merchantStock);
            return true;
        }
        return false;
    }

    public int buyAProduct(int userId,int prodId,int meshStockId,int count){
        User user=getUser(userId);
        Product product=productService.getPrice(prodId);
        MerchantStock merchantStock =merchantStockService.getMerch(meshStockId);
        if(user ==null||product==null||merchantStock==null){
            return 400;
        }
        if(merchantStock.getProductid()!=product.getId()){
            return 500;
        }
        if(user.getBalance()<=0||user.getBalance()<product.getPrice()){
            return 600;
        }
        if(count>merchantStock.getStock()){
            return 700;
        }
        //return 200 is done
        //return 400 any id is not correct
        //return 500 produect id is not correct
        //return 600 the user balance is not enough
        //return 700 the count big the stock
        //return 800 error in update
        merchantStock.setStock(merchantStock.getStock()-count);
        user.setBalance(user.getBalance()-product.getPrice());
        boolean resultUser=updateItem(userId,user);
        if(!resultUser){
            return 800;
        }
        boolean resMeck=merchantStockService.update(meshStockId,merchantStock);
        if(!resMeck){
            return 800;
        }
        return 200;

    }
}
