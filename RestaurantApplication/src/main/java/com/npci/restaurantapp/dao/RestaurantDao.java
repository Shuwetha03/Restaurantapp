package com.npci.restaurantapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.restaurantapp.entity.FoodItem;
import com.npci.restaurantapp.entity.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{

	public FoodItem save(FoodItem fooditem);

	public List<Restaurant> findBySNameOrCityOrStateOrPincode(String sName, String city, String state, Integer pincode);

}
