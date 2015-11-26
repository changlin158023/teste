package com.tasteshared.javabean;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "t_address")
public class Address {

	@Column
	private Integer pk_address;
	@Column
	private Integer fk_user;
	@Column
	private String contacts;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private String desc;
	@Column
	private String zipcode;
	@Column
	private Integer enable;
	public Integer getPk_address() {
		return pk_address;
	}
	public void setPk_address(Integer pk_address) {
		this.pk_address = pk_address;
	}
	public Integer getFk_user() {
		return fk_user;
	}
	public void setFk_user(Integer fk_user) {
		this.fk_user = fk_user;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
	
}
