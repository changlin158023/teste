package com.tasteshared.javabean;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "t_order")
public class Order {

	@Column
	private Integer pk_order;
	@Column
	private Integer fk_user;
	@Column
	private Integer fk_dish;
	@Column
	private Integer fk_chef;
	@Column
	private Integer fk_address;
	@Column
	private String add_time;
	@Column
	private String arrival_time;
	@Column
	private String eta_time;
	@Column
	private Integer count;
	@Column
	private Double money;
	@Column
	private Integer process;
	@Column
	private String desc;
	@Column
	private Integer enable;
	public Integer getPk_order() {
		return pk_order;
	}
	public void setPk_order(Integer pk_order) {
		this.pk_order = pk_order;
	}
	public Integer getFk_user() {
		return fk_user;
	}
	public void setFk_user(Integer fk_user) {
		this.fk_user = fk_user;
	}
	public Integer getFk_dish() {
		return fk_dish;
	}
	public void setFk_dish(Integer fk_dish) {
		this.fk_dish = fk_dish;
	}
	public Integer getFk_chef() {
		return fk_chef;
	}
	public void setFk_chef(Integer fk_chef) {
		this.fk_chef = fk_chef;
	}
	public Integer getFk_address() {
		return fk_address;
	}
	public void setFk_address(Integer fk_address) {
		this.fk_address = fk_address;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getEta_time() {
		return eta_time;
	}
	public void setEta_time(String eta_time) {
		this.eta_time = eta_time;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getProcess() {
		return process;
	}
	public void setProcess(Integer process) {
		this.process = process;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
	
}
