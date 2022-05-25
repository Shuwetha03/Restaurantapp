package com.npci.restaurantapp.services;

import java.util.List;

import com.npci.restaurantapp.entity.Comment;
import com.npci.restaurantapp.entity.FoodItem;
import com.npci.restaurantapp.entity.Restaurant;

public interface IRestaurantServices {


	Restaurant newRestaurant(Restaurant restaurant);

	FoodItem newFoodItem(FoodItem foodItem) ;

	//    FoodItem reviseFoodItem( FoodItem fooditem) ;

	String cutoutFoodItem( Integer itemID ) ;

	Comment newComment(Comment comment);

	List<Comment> Comments();
}
