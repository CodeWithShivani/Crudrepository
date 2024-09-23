package com.first.crudproject.pagecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.crudproject.entities.Item;
import com.first.crudproject.services.ItemService;

@RestController

@RequestMapping("/items")
public class ItemController {
	
	 @Autowired
	    private ItemService itemService;

	    // GET all items
	    @GetMapping("/getalllist")
	    List<Item> getallitemList() {
			return itemService.getallitemList();
		}

	    // GET item by id
	    @GetMapping("/{id}")
	    public Item getItemById(@PathVariable Integer id) {
	        return itemService.getItemById(id)
	                          .orElseThrow(() -> new RuntimeException("Item not found"));
	    }

	    // POST create a new item
	    @PostMapping("/createlist")
	    public Item addItem(@RequestBody Item item) {
	        return itemService.addItem(item);
	    }

	    // PUT update an existing item
	    @PutMapping("/update/{id}")
	    public Item updateItem(@PathVariable Integer id, @RequestBody Item updatedItem) {
	        return itemService.updateItem(id, updatedItem);
	    }

	    // DELETE an item
	    @DeleteMapping("/delete/{id}")
	    public void deleteItem(@PathVariable Integer id) {
	        itemService.deleteItem(id);
	    }

}
