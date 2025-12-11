package com.example.Menu.Management.service;

import com.example.Menu.Management.model.Item;
import com.example.Menu.Management.repository.MenuRepository;
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
    public Item updateItem(Long id, Item item)  {
        if(menuRepository.existsById(id)){
            menuRepository.save(item);
        }
        else {
            throw new RuntimeException("Item not found");
        }
        return item;
    }
    public void deleteItem(Long id) {
        menuRepository.delete(menuRepository.findById(id).orElseThrow(()->new RuntimeException("Item not found!")));
    }

}
