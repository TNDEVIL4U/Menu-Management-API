package com.example.Menu.Management.service;

import com.example.Menu.Management.dto.ItemMapper;
import com.example.Menu.Management.dto.ItemRequestDto;
import com.example.Menu.Management.exceptions.ItemNotFoundException;
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
    public Item updateItem(Long id, ItemRequestDto dto)  {

        Item item = menuRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Item not found"));
        ItemMapper.updateEntity(item,dto);
        return menuRepository.save(item);
    }
    public void deleteItem(Long id) {
        menuRepository.delete(menuRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Item not found")));
    }

}
