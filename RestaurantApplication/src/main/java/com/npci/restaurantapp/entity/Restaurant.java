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
public class Restaurant {

	@Id
	@Column(name="RestaurantId")
	Integer restaurantId;
	
	@Column(name="DoorNo")
	Integer doorNo;
	
	@Column(name="StreetName")
	String sName;
	
	@Column(name="City")
	String city;
	
	@Column(name="State")
	Long state;
	
	@Column(name="Pincode")
	Integer pincode;
	
}
