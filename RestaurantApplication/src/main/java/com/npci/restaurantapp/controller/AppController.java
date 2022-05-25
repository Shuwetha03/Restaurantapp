package com.npci.restaurantapp.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.npci.restaurantapp.entity.Comment;
import com.npci.restaurantapp.entity.FoodItem;
import com.npci.restaurantapp.entity.Restaurant;
import com.npci.restaurantapp.services.IRestaurantServices;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	IRestaurantServices irestaurantservices;

	@PostMapping("/rest")
	public ResponseEntity<Restaurant> newRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant newRestaurant = irestaurantservices.newRestaurant(restaurant);
		return new ResponseEntity<>(newRestaurant,HttpStatus.CREATED);
	}

	@PostMapping("/food")
	public ResponseEntity<FoodItem> newFoodItem(@RequestBody FoodItem foodItem) {
		FoodItem newFoodItem = irestaurantservices.newFoodItem(foodItem);
		return new ResponseEntity<>(newFoodItem,HttpStatus.CREATED);
    }
	
	@PutMapping("/ud")
	public ResponseEntity<String> updateFood(@RequestBody FoodItem foodItem) {
		FoodItem f = irestaurantservices.updateFood(foodItem);
		return new ResponseEntity<String>(f.getItemType()+" updated successfully",HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/item/{ItemID}")
	public  ResponseEntity<String> cutoutFoodItem(@PathVariable(value="ItemID") Integer itemID ) {
		String cutoutFoodItem = irestaurantservices.cutoutFoodItem(itemID);
		return new ResponseEntity<>(cutoutFoodItem,HttpStatus.OK);
	}
	
	@GetMapping("/rest/{sName}/{city}/{state}/{pincode}")
	public ResponseEntity<Restaurant> getByfirstSNameOrCityOrStateOrPincode(@PathVariable(value="sName",required = false)String sName,@PathVariable(value="city",required = false)String city ,@PathVariable(value="state",required = false)String state,@PathVariable(value="pincode",required = false) Integer pincode)
	{
		Restaurant r = irestaurantservices.getByfirstSNameOrCityOrStateOrPincode(sName,city,state,pincode);
		return new ResponseEntity<>(r,HttpStatus.OK);
	}


	@PostMapping("/comment")
	public ResponseEntity<Comment> newComment(@RequestBody Comment comment) {
		Comment newComment = irestaurantservices.newComment(comment);
		return new ResponseEntity<>(newComment,HttpStatus.CREATED);
    }

	@GetMapping("/comments")
	public ResponseEntity<List<Comment>> Comments(){
		List<Comment> comments = irestaurantservices.Comments();
		return new ResponseEntity<>(comments,HttpStatus.ACCEPTED);
	}
	@GetMapping("/comments/{restID}")
	public ResponseEntity<List<Comment>> Comments(@PathVariable(value="restID") Integer restID){
		List<Comment> comments = irestaurantservices.Comments(restID);
		return new ResponseEntity<>(comments,HttpStatus.ACCEPTED);
	}

}
