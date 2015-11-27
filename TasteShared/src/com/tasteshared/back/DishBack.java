package com.tasteshared.back;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tasteshared.javabean.Chef;
import com.tasteshared.javabean.DishBackMessage;

public class DishBack {

	@Expose
	private Integer statusMsg;
	@Expose
	private List<DishBackMessage> returnData = new ArrayList<DishBackMessage>();
	@SerializedName("interface")
	@Expose
	private String _interface;

	public Integer getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(Integer statusMsg) {
		this.statusMsg = statusMsg;
	}

	public List<DishBackMessage> getReturnData() {
		return returnData;
	}

	public void setReturnData(List<DishBackMessage> returnData) {
		this.returnData = returnData;
	}

	public String get_interface() {
		return _interface;
	}

	public void set_interface(String _interface) {
		this._interface = _interface;
	}

}
