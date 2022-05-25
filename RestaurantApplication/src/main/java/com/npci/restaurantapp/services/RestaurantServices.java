package com.npci.restaurantapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.npci.restaurantapp.dao.CommentDao;
import com.npci.restaurantapp.dao.FoodItemDao;
import com.npci.restaurantapp.dao.RestaurantDao;
import com.npci.restaurantapp.entity.Comment;
import com.npci.restaurantapp.entity.FoodItem;
import com.npci.restaurantapp.entity.Restaurant;

@Service
public class RestaurantServices implements IRestaurantServices {

	@Autowired
	RestaurantDao restaurantdao;
	FoodItemDao foodItemdao;
	CommentDao commentdao;

	@Override
	public Restaurant newRestaurant(Restaurant restaurant) {
		Restaurant newRestaurant = restaurantdao.save(restaurant);
		return newRestaurant;
	}

	@Override
	public FoodItem newFoodItem(FoodItem foodItem) {
		FoodItem Fooditem = foodItemdao.save(foodItem);
		return Fooditem;
	}



	@Override
	public String cutoutFoodItem( Integer itemID ) {
		foodItemdao.deleteById(itemID);
		return "Food Item with ID:" + itemID +"  deleted Successfully";
	}

	//	@Override
	//	public FoodItem reviseFoodItem(FoodItem fooditem) {
	//		foodItemdao.fin
	//		return null;
	//	}


	public Comment newComment(@RequestBody Comment comment) {
		Comment commentsave = commentdao.save(comment);

		return commentsave;

	}

	@Override
	public List<Comment> Comments() {
		List<Comment> findAll = commentdao.findAll();
		return findAll;
	}




}
