package com.tasteshared.back;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tasteshared.javabean.DishDetailsBackMessage;

public class DishDetailsBack {

	@Expose
	private Integer statusMsg;
	@Expose
	private List<DishDetailsBackMessage> returnData = new ArrayList<DishDetailsBackMessage>();
	@SerializedName("interface")
	@Expose
	private String _interface;

	public Integer getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(Integer statusMsg) {
		this.statusMsg = statusMsg;
	}

	public List<DishDetailsBackMessage> getReturnData() {
		return returnData;
	}

	public void setReturnData(List<DishDetailsBackMessage> returnData) {
		this.returnData = returnData;
	}

	public String get_interface() {
		return _interface;
	}

	public void set_interface(String _interface) {
		this._interface = _interface;
	}

}
