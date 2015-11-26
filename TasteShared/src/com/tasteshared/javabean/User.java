package com.tasteshared.javabean;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "t_user")
public class User {

	@Column
	private Integer pk_user;
	@Column
	private String password;
	@Column
	private String avatar_path;
	@Column
	private String wechat_sn;
	@Column
	private String phone;
	@Column
	private Integer type;
	@Column
	private String nickname;
	@Column
	private String add_time;
	@Column
	private Integer enable;
	@Column
	private String remark;
	
	public Integer getPk_user() {
		return pk_user;
	}
	public void setPk_user(Integer pk_user) {
		this.pk_user = pk_user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar_path() {
		return avatar_path;
	}
	public void setAvatar_path(String avatar_path) {
		this.avatar_path = avatar_path;
	}
	public String getWechat_sn() {
		return wechat_sn;
	}
	public void setWechat_sn(String wechat_sn) {
		this.wechat_sn = wechat_sn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
