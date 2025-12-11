package com.example.Menu.Management.repository;

import com.example.Menu.Management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Item,Long> {

}
