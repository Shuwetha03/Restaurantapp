package org.npci.restaurantapp.dao;

import java.util.List;

import org.npci.restaurantapp.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

	@Query("select r FROM Restaurant r WHERE r.streetName = :s or r.city = :c or r.state = :st or r.pinCode = :p")
	public List<Restaurant> findByStreetNameOrCityOrStateOrPinCode(@Param("s") String streetName, @Param("c") String city, @Param("st") String state, @Param("p") Integer pinCode);
//	public List<Restaurant> findByStreetName(String streetName);
	
	
}
