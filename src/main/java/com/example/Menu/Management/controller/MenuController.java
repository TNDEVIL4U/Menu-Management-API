package com.example.Menu.Management.controller;

import com.example.Menu.Management.model.Item;
import com.example.Menu.Management.service.MenuService;
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
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        try {
            return new ResponseEntity<>(menuService.createItem(item), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable long id,@RequestBody Item item) {
        try {
            menuService.updateItem(id,item);
            return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Item not found",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable long id) {
        try{
        menuService.deleteItem(id);
        return new ResponseEntity<>("Item deleted",HttpStatus.OK);
    }
        catch(Exception e){
        return new ResponseEntity<>("Error Item not found",HttpStatus.BAD_REQUEST);
        }
    }
}
