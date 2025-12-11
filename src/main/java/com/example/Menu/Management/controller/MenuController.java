package com.example.Menu.Management.controller;

import com.example.Menu.Management.exceptions.ItemNotFoundException;
import com.example.Menu.Management.model.Item;
import com.example.Menu.Management.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/items")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(menuService.getItems(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
            return new ResponseEntity<>(menuService.createItem(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable long id,@Valid @RequestBody Item item) {
            menuService.updateItem(id,item);
            return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable long id) {
        menuService.deleteItem(id);
        return new ResponseEntity<>("Item deleted successfully",HttpStatus.OK);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(value= ItemNotFoundException.class)
    public ResponseEntity<String> handleException(ItemNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
