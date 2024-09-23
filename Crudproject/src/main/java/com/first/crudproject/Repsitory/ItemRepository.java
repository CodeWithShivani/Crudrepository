package com.first.crudproject.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.crudproject.entities.Item;

public interface  ItemRepository extends JpaRepository<Item ,Integer>{
}
