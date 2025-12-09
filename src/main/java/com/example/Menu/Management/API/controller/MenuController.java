package com.example.Menu.Management.API.controller;

import com.example.Menu.Management.API.model.Item;
import com.example.Menu.Management.API.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(menuService.getItems(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return new ResponseEntity<>(menuService.createItem(item),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable int id,@RequestBody Item item) {
        try {
            menuService.updateItem(id,item);
            return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Item not found",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id) {
        try{
        menuService.deleteItem(id);
        return new ResponseEntity<>("Item deleted",HttpStatus.OK);
    }
        catch(Exception e){
        return new ResponseEntity<>("Error Item not found",HttpStatus.BAD_REQUEST);
        }
    }
}
