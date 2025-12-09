package com.example.Menu.Management.API.service;

import com.example.Menu.Management.API.model.Item;
import com.example.Menu.Management.API.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Item> getItems() {
        return menuRepository.findAll();
    }

    public Item createItem(Item item) {
        return menuRepository.save(item);
    }
    public Item updateItem(int id, Item item)  {
        if(menuRepository.existsById(id)){
            menuRepository.save(item);
        }
        else {
            throw new RuntimeException("Item not found");
        }
        return item;
    }
    public void deleteItem(int id) {
        menuRepository.delete(menuRepository.findById(id).orElseThrow(()->new RuntimeException("Item not found!")));
    }

}
