package com.first.crudproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.crudproject.Repsitory.ItemRepository;
import com.first.crudproject.entities.Item;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getallitemList() {
		return itemRepository.findAll();
	}

	public Optional<Item> getItemById(Integer id) {
		return itemRepository.findById(id);
	}

	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	
	 public Item updateItem(Integer id, Item updatedItem) { return
	 itemRepository.findById(id) .map(item -> {
	 item.setName(updatedItem.getName());
	 item.setDescription(updatedItem.getDescription()); return
	 itemRepository.save(item); }).orElseThrow(() -> new
	 RuntimeException("Item not found")); }
	 

	public void deleteItem(Integer id) {
		itemRepository.deleteById(id);

	}

	

}
