package com.tasteshared.back;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tasteshared.javabean.Chef;

public class EnterBack {

	@Expose
	private Integer statusMsg;
	@Expose
	private List<Chef> returnData = new ArrayList<Chef>();
	@SerializedName("interface")
	@Expose
	private String _interface;

	public Integer getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(Integer statusMsg) {
		this.statusMsg = statusMsg;
	}

	public List<Chef> getReturnData() {
		return returnData;
	}

	public void setReturnData(List<Chef> returnData) {
		this.returnData = returnData;
	}

	public String get_interface() {
		return _interface;
	}

	public void set_interface(String _interface) {
		this._interface = _interface;
	}

}
