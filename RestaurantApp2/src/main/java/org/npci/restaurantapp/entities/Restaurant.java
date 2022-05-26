package org.npci.restaurantapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Restaurant")
public class Restaurant {

	@Id
	@Column(name = "restaurantId")
	Long restaurantId;
	
	@Column(name = "doorNo")
	Integer doorNo;
	
	@Column(name = "street")
	String streetName;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state")
	String state;
	
	@Column(name = "pinCode")
	Integer pinCode;

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
	 * @return the doorNo
	 */
	public Integer getDoorNo() {
		return doorNo;
	}

	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(Integer doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pinCode
	 */
	public Integer getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Restaurant(Long restaurantId, Integer doorNo, String streetName, String city, String state,
			Integer pinCode) {
		super();
		this.restaurantId = restaurantId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Restaurant() {
		
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", doorNo=" + doorNo + ", streetName=" + streetName
				+ ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	
}
