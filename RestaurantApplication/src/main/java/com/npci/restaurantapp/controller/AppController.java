package com.npci.restaurantapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.restaurantapp.dao.CommentDao;
import com.npci.restaurantapp.dao.FoodItemDao;
import com.npci.restaurantapp.dao.RestaurantDao;
import com.npci.restaurantapp.entity.Restaurant;
import com.npci.restaurantapp.services.IRestaurantServices;

@RestController
@RequestMapping("/restaurant")
public class AppController {
	
	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	IRestaurantServices iRestaurantServices;
	
	@PostMapping("/save")
	public ResponseEntity<Restaurant> addingR(@RequestBody Restaurant restaurant){
		
		Restaurant addR = iRestaurantServices.addR(restaurant);
		return new ResponseEntity<Restaurant>(addR, HttpStatus.CREATED);
	}

}
