package com.example.springproject3.service;

import com.example.springproject3.models.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks=new ArrayList<>();

    public ArrayList<MerchantStock> getAll(){
        return merchantStocks;
    }
    public void addItem(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);

    }
    public boolean update(int id,MerchantStock merchantStock){
        for (int i=0;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id){
        for(int i=0;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean IsHave(int id){
        for(int i =0;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }
    public MerchantStock getMerch(int id){
        for(int i =0;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                return merchantStocks.get(i);
            }
        }
        return null;
    }
}
