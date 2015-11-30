package com.tasteshared.javabean;

import java.io.Serializable;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "t_dish")
public class DishBackMessage implements Serializable {

	@Column
	private Integer pk_dish;
	@Column
	private String name;
	@Column
	private String remark;
	@Column
	private Double price;
	@Column
	private String add_time;
	@Column
	private Integer type;
	@Column
	private Integer rating;
	@Column
	private Integer fk_chef;
	@Column
	private Integer enable;
	@Column
	private Integer unOrders;
	@Column
	private Integer needToMake;
	@Column
	private Integer waitForDelivery;

	public Integer getPk_dish() {
		return pk_dish;
	}

	public void setPk_dish(Integer pk_dish) {
		this.pk_dish = pk_dish;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getFk_chef() {
		return fk_chef;
	}

	public void setFk_chef(Integer fk_chef) {
		this.fk_chef = fk_chef;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getunOrders() {
		return unOrders;
	}

	public void setunOrders(Integer unOrders) {
		this.unOrders = unOrders;
	}

	public Integer getneedToMake() {
		return needToMake;
	}

	public void setneedToMake(Integer needToMake) {
		this.needToMake = needToMake;
	}

	public Integer getwaitForDelivery() {
		return waitForDelivery;
	}

	public void setwaitForDelivery(Integer waitForDelivery) {
		this.waitForDelivery = waitForDelivery;
	}

}
