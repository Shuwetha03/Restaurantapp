package org.npci.restaurantapp.dao;

import java.util.List;

import org.npci.restaurantapp.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

	@Query("select r FROM Restaurant r WHERE (:s is null or r.streetName = :s) and (:c is null or r.city = :c) and (:st is null or r.state = :st) and (:p is null or r.pinCode = :p)")
	public List<Restaurant> findByStreetNameOrCityOrStateOrPinCode(@Param("s") String streetName, @Param("c") String city, @Param("st") String state, @Param("p") Integer pinCode);

	
	
}
