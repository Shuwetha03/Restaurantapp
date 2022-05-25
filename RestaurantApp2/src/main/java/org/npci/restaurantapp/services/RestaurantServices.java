package org.npci.restaurantapp.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.npci.restaurantapp.dao.CommentDao;
import org.npci.restaurantapp.dao.FoodItemDao;
import org.npci.restaurantapp.dao.RestaurantDao;
import org.npci.restaurantapp.entities.Comment;
import org.npci.restaurantapp.entities.FoodItem;
import org.npci.restaurantapp.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServices implements IRestaurantServices {

	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Override
	public Restaurant addR(Restaurant restaurant) {
		Restaurant r = restaurantDao.save(restaurant);
		return r;
	}

	@Override
	public FoodItem addFI(FoodItem foodItem) {
		FoodItem fi = foodItemDao.save(foodItem);
		return fi;
	}

	@Override
	public String trashFI(Long id) {
		foodItemDao.deleteById(id);
		return "deleted according to"+id;
	}

	@Override
	public FoodItem changeFI(FoodItem foodItem) {
		FoodItem fin = foodItemDao.save(foodItem);
		return fin;
	}

	@Override
	public Comment fb(Comment comment) {
		Comment c = commentDao.save(comment);
		return c;
	}

	@Override
	public List<Comment> sr(Integer id) {
		List<Comment> ee = commentDao.findByRestaurantIdOrderByCommentIdDesc(id);
		return ee;
	}

	@Override
	public List<Restaurant> fil(String street, String city, String state, Integer pin) {
		// TODO Auto-generated method stub
		List<Restaurant> ffff = restaurantDao.findByStreetNameOrCityOrStateOrPinCode(street, city, state, pin);
		for(Restaurant a:ffff) {
			Long rId = a.getRestaurantId();
			List<FoodItem> findByRestaurantId = foodItemDao.findByRestaurantId(rId);
			
			System.out.println(findByRestaurantId);
		}
		
		return ffff;
	}

//	@Override
//	public List<Restaurant> sss(String street) {
//		List<Restaurant> findByStreetName = restaurantDao.findByStreetName(street);
//		return findByStreetName;
//	}


}
