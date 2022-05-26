package org.npci.restaurantapp.controller;

import java.util.Comparator;
import java.util.List;

import org.npci.restaurantapp.dao.CommentDao;
import org.npci.restaurantapp.dao.FoodItemDao;
import org.npci.restaurantapp.dao.RestaurantDao;
import org.npci.restaurantapp.entities.Comment;
import org.npci.restaurantapp.entities.FoodItem;
import org.npci.restaurantapp.entities.Restaurant;
import org.npci.restaurantapp.services.IRestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	IRestaurantServices iRestaurantServices;
	
	@PostMapping("/r")
	public ResponseEntity<Restaurant> addingR(@RequestBody Restaurant restaurant){
		Restaurant addR = iRestaurantServices.addR(restaurant);
		
		return new ResponseEntity<Restaurant>(addR, HttpStatus.CREATED);
	}
	
	@PostMapping("/fi")
	public ResponseEntity<FoodItem> addingFI(@RequestBody FoodItem foodItem){
		FoodItem addFI = iRestaurantServices.addFI(foodItem);
		
		return new ResponseEntity<FoodItem>(addFI, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/d/{itemId}")
	public ResponseEntity<String> trashingFI(@PathVariable("itemId") Long id){
		String trashFI = iRestaurantServices.trashFI(id);
		return new ResponseEntity<String>(trashFI, HttpStatus.OK);
	}
	
	@PutMapping("/a/nfi")
	public ResponseEntity<FoodItem> changingFI(@RequestBody FoodItem foodItem){
		FoodItem changeFI = iRestaurantServices.changeFI(foodItem);
		return new ResponseEntity<FoodItem>(changeFI, HttpStatus.OK);
	}
	
	@PostMapping("/rev")
	public ResponseEntity<Comment> feedB(@RequestBody Comment comment){
		Comment fb = iRestaurantServices.fb(comment);
		return new ResponseEntity<Comment>(fb, HttpStatus.CREATED);
	}
	
	@GetMapping("/sRev/{rid}")
	public ResponseEntity<List<Comment>> seeR(@PathVariable("rid") Integer id){
		List<Comment> sr = iRestaurantServices.sr(id);
		return new ResponseEntity<List<Comment>>(sr, HttpStatus.OK);
	}
	
	@GetMapping("/f")
	public ResponseEntity<List<List<FoodItem>>> filter(@RequestParam (value = "str", required = false) String street, @RequestParam (value = "city", required = false) String city, @RequestParam (value = "state", required = false) String state, @RequestParam (value = "pin", required = false) Integer pin){
		List<List<FoodItem>> fil = iRestaurantServices.fil(street, city, state, pin);
		
		return new ResponseEntity<List<List<FoodItem>>>(fil, HttpStatus.OK);
	} 

	
	
}
