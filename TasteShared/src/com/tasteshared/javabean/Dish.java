package com.tasteshared.javabean;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "t_dish")
public class Dish {

	@Column
	private Integer pk_dish;
	@Column
	private String desc;
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
	public Integer getPk_dish() {
		return pk_dish;
	}
	public void setPk_dish(Integer pk_dish) {
		this.pk_dish = pk_dish;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	
	
}
