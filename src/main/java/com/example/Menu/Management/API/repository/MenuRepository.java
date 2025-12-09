package com.example.Menu.Management.API.repository;

import com.example.Menu.Management.API.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Item,Integer> {

}
