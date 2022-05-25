package com.npci.restaurantapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class FoodItem {
	
	@Id
	@Column(name="ItemId")
	Integer itemId;
	
	@Column(name="RestaurantId")
	Integer restaurantId;
	
	@Column(name="ItemType")
	String itemType;
	
	@Column(name="Description")
	String description;
}
