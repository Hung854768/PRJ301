/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class Cart {
    private List<Item> items;
    
    public Cart(List<Item> items) {
        this.items = items;
    }

    public Cart() {
        items= new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Item getItemById(String id){////
        for(Item i : items){
            if(i.getProduct().getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    
    public int getQuantityById(String id){////
        return getItemById(id).getQuantity();
    }
    
    public void addItem(Item newItem) {
    Item existingItem = getItemById(newItem.getProduct().getId());
    if (existingItem != null) {
        existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
    } else {
        items.add(newItem);
    }
}
    public void removeItem(String i ){///
        if(getItemById(i)!= null){
           items.remove(getItemById(i));
        }
    }
    public int getTotalMoney(){
        int t =0;
        for(Item i : items){
            t+=i.getQuantity()*i.getPrice();
        }
        return t;
    }
}
