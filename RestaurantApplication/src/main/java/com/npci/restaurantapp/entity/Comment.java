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

public class Comment {

	
	@Id
	@Column(name="CommentId")
	Integer cId;
	
	@Column(name="Comments")
	String comments;
	
	@Column(name="RestaurantId")
	Integer restaurantId;
	
	
}
