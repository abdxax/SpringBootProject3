package com.example.springproject3.service;

import com.example.springproject3.models.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> merchants=new ArrayList<>();

    public ArrayList<Merchant> getAll(){
        return merchants;
    }
    public void addItem(Merchant merchant){
        merchants.add(merchant);


    }
    public boolean updateItem(int id,Merchant merchant){
        for(int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }
    public boolean deleteItem(int id){
        for(int i=0;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean IsHave(int id){
        for(int i =0;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }
}

