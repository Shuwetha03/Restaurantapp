package org.npci.restaurantapp.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.npci.restaurantapp.dao.CommentDao;
import org.npci.restaurantapp.dao.FoodItemDao;
import org.npci.restaurantapp.dao.RestaurantDao;
import org.npci.restaurantapp.entities.Comment;
import org.npci.restaurantapp.entities.FoodItem;
import org.npci.restaurantapp.entities.Restaurant;
import org.npci.restaurantapp.exceptions.RestaurantPinCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.npci.restaurantapp.exceptions.RestaurantFoodItemNullException;

import org.npci.restaurantapp.exceptions.RestaurantCommentException;

import org.npci.restaurantapp.exceptions.CommentDescriptionException;

import org.npci.restaurantapp.exceptions.FoodItemIdException;

import org.npci.restaurantapp.exceptions.FoodItemNullException;


@Service
public class RestaurantServices implements IRestaurantServices {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	@Autowired
	CommentDao commentDao;
	
	
	Logger LOGGER = LoggerFactory.getLogger("RestaurantServices.class");
	
	@Override
	public Restaurant addR(Restaurant restaurant) {
		
		if(!(Integer.toString(restaurant.getPinCode()).matches("^[1-9][0-9]{5}$"))) {
			throw new RestaurantPinCodeException("Pincode Should be six Digit");
		}
		Restaurant r = restaurantDao.save(restaurant);
		
		LOGGER.info("Resturent detail:{}",r);
		return r;
	}

	@Override
	public FoodItem addFI(FoodItem foodItem) {
		
		if(foodItem.getItemType()==null) {
			throw new FoodItemNullException("FoodItem type is null ");
		}
		
		FoodItem fi = foodItemDao.save(foodItem);
		LOGGER.info("FoodItem detail:{}",fi);
		return fi;
	}

	@Override
	public String trashFI(Long id) {
		
		LOGGER.info("ItemId :{}",id);
		Optional<FoodItem> FoodItem = foodItemDao.findById(id);
		if(!FoodItem.isPresent()) {
			throw new FoodItemIdException("There is no Food Item with ItemID:"+id);
		}
		foodItemDao.deleteById(id);
		
		return "deleted according to id: "+id;
	}

	@Override
	public FoodItem changeFI(FoodItem foodItem) {
		FoodItem fin = foodItemDao.save(foodItem);
		
		LOGGER.info("FoodItem id: {} updated.",foodItem.getItemId());
		return fin;
	}

	@Override
	public Comment fb(Comment comment) {
		
		if(comment.getCommentDescription()== null) {
			throw new CommentDescriptionException("Comment Field is Empty");
		}
		Comment c = commentDao.save(comment);
		LOGGER.info("Comment saved in table is:{}",c);
		return c;
	}

	@Override
	public List<Comment> sr(Integer id) {
		LOGGER.info("Resturent ID :{}",id);
		List<Comment> ee = commentDao.findByRestaurantIdOrderByCommentIdDesc(id);
		if(ee.isEmpty()) {
			throw new RestaurantCommentException("The is no comment for this restaurant id:"+id);
		}
		LOGGER.info("Comment for Resturent ID {}",ee);
		return ee;
	}

	@Override
	public List<List<FoodItem>> fil(String street, String city, String state, Integer pin) {
		
		List<Restaurant> rest = restaurantDao.findByStreetNameOrCityOrStateOrPinCode(street, city, state, pin);
		
		if(rest.isEmpty()) {
			throw new RestaurantFoodItemNullException("OOPS!! No Restaurant ");
		}
		
		List<List<FoodItem>> item = new ArrayList<>();
		for(Restaurant r:rest) {
			Long rId = r.getRestaurantId();
			List<FoodItem> findByRestaurantId = foodItemDao.findByRestaurantId(rId);
			item.add(findByRestaurantId);
		}
		LOGGER.info("List of food item in restaurant:{}",item);
		return item;	
		
	}




}
