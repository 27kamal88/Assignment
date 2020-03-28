package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ItemNotFoundException;
import com.example.model.Item;
import com.example.repository.ItemRepository;

@RestController
public class ItemController {
   @Autowired
	ItemRepository itemRepo;
	
   @GetMapping("items")
	public List<Item> getItems()
	{
		List<Item> items=(List<Item>)itemRepo.findAll();
		if(items==null)
			 throw new ItemNotFoundException("Item table is empty");
		return items;
	}
   @PostMapping("addItem")
	public Item saveItem(@RequestBody Item item)
	{   itemRepo.save(item);
	    return item;
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable int id) {
      Item item=itemRepo.findById(id).orElse(null);
      if(item==null)
			 throw new ItemNotFoundException("id-"+id);
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteItem/{id}")
	public  ResponseEntity<Item> deleteItem(@PathVariable int id) {
		Item item = itemRepo.findById(id).orElse(null);
		if(item==null)
			 throw new ItemNotFoundException("Item Not Found in Database");
		itemRepo.deleteById(id);
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<Item> getItemByEMail(@PathVariable String email) {
	  Item item=(Item)itemRepo.findByEmail(email);
		if(item==null)
			 throw new ItemNotFoundException("with email"+email);
 
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}

}
