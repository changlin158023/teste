package com.tasteshared;

import com.tasteshared.javabean.Chef;

public class TheParameter {

	//(1)����ʦ����
	private static Chef chef;

	public static Chef getChef() {
		return chef;
	}

	public static void setChef(Chef chef) {
		TheParameter.chef = chef;
	}
}
