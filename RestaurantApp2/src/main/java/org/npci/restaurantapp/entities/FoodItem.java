package org.npci.restaurantapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "FoodItems")

public class FoodItem {

	@Id
	@Column(name = "itemId")
	Long itemId;
	
	@Column(name = "restaurantId")
	Long restaurantId;
	
	@Column(name = "type")
	String itemType;
	
	@Column(name = "description")
	String itemDescription;

	/**
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the restaurantId
	 */
	public Long getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public FoodItem(Long itemId, Long restaurantId, String itemType, String itemDescription) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
	}

	public FoodItem() {
	
	}

	@Override
	public String toString() {
		return "FoodItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemType=" + itemType
				+ ", itemDescription=" + itemDescription + "]";
	}
	
	
	
}
