package com.tasteshared.javabean;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "t_dish_detail")
public class Dish_Detail {

	@Column
	private Integer pk_dish_detail;
	@Column
	private Integer fk_dish;
	@Column
	private Integer type;
	@Column
	private String content;
	@Column
	private Integer font;
	@Column
	private String color;
	@Column
	private String image_path;
	@Column
	private Integer background;
	@Column
	private Integer enable;
	public Integer getPk_dish_detail() {
		return pk_dish_detail;
	}
	public void setPk_dish_detail(Integer pk_dish_detail) {
		this.pk_dish_detail = pk_dish_detail;
	}
	public Integer getFk_dish() {
		return fk_dish;
	}
	public void setFk_dish(Integer fk_dish) {
		this.fk_dish = fk_dish;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getFont() {
		return font;
	}
	public void setFont(Integer font) {
		this.font = font;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public Integer getBackground() {
		return background;
	}
	public void setBackground(Integer background) {
		this.background = background;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
	
}
