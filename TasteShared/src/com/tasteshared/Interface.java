package com.tasteshared;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.android.volley.VolleyError;
import com.github.volley_examples.app.MyVolley;
import com.github.volley_examples.app.VolleyListenner;
import com.tasteshared.Utils.Bean2Map;
import com.tasteshared.javabean.Chef;
import com.tasteshared.javabean.Dish;
import com.tasteshared.javabean.Order;

import android.content.Context;
import android.util.Log;


public class Interface {

	String url = "http://120.26.118.226/app/teste/te_interface.php";

	private static Interface Thisinterface = new Interface();

	private Interface() {

	}

	public static Interface getInstance() {
		return Thisinterface;
	}
	
	// 厨师登录
	String kCheflogin = "5";
	//菜品
	String kDishs = "2";
	//菜品的所有订单
	String kAllDishs = "6";
	//订单修改
	String kOrder = "7";
	
	
	
	//普通
	public Map<String, String> packParams(Object classObject,
			String interfaceType) {
		Map map = Bean2Map.ConvertObjToMap(classObject);
		Log.e("Interface", "map------" + map);
		JSONObject jsonObject = new JSONObject(map);
		Map<String, String> params = new HashMap<String, String>();

		params.put("request_type", interfaceType);
		Log.e("Interface", "传 入的json:" + jsonObject.toString());
		params.put("request_data", jsonObject.toString());

		return params;
	}
	
	
	
	
	//厨师登录	
	private void ChefLoginPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError1(error);
				Log.e("失败", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone1(response);
			}
		});
	}
	
	//菜品
	private void DishPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError2(error);
				Log.e("失败", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone2(response);
			}
		});
	}
	
	//菜品的所有订单
	private void AllDishPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError3(error);
				Log.e("失败", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone3(response);
			}
		});
	}
	
	//订单修改
	private void OrderPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError4(error);
				Log.e("失败", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone4(response);
			}
		});
	}
	
	
	
	
	
	// 厨师登录
	public void chefLogin(Context context, Chef chef) {
		ChefLoginPost(context, packParams(chef, kCheflogin));
	}
	// 菜品
	public void dishing(Context context, Chef chef) {
		DishPost(context, packParams(chef, kDishs));
	}
	// 菜品的所以订单
	public void Alldishing(Context context, Dish dish) {
		AllDishPost(context, packParams(dish, kAllDishs));
	}
	// 订单修改
	public void odering(Context context, Order order) {
		OrderPost(context, packParams(order, kOrder));
	}
	
	
	
	// 厨师登录
	private static ChefLoginListenner chefLoginListenner;
	// 菜品
	private static DishListenner dishListenner;
	// 菜品的所有订单
	private static AllDishListenner alldishListenner;
	// 订单修改
	private static OrderListenner orderListenner;
	
	
	
	
	// 厨师登录
	public interface ChefLoginListenner {
		void success(String A);
		
		void defail(Object B);
	}
	// 菜品
	public interface DishListenner {
		void success(String A);
		
		void defail(Object B);
	}
	// 菜品的所有订单
	public interface AllDishListenner {
		void success(String A);
		
		void defail(Object B);
	}
	// 订单修改
	public interface OrderListenner {
		void success(String A);
		
		void defail(Object B);
	}
	
	
	
	
	//厨师登录
	public void setPostListener(ChefLoginListenner listener) {
		this.chefLoginListenner = listener;
	}
	//菜品
	public void setPostListener(DishListenner listener) {
		this.dishListenner = listener;
	}
	//菜品的所有订单
	public void setPostListener(AllDishListenner listener) {
		this.alldishListenner = listener;
	}
	//订单修改
	public void setPostListener(OrderListenner listener) {
		this.orderListenner = listener;
	}
	
	
	
	
	
	//厨师登录
	public static void requestDone1(String theObject) {
		chefLoginListenner.success(theObject);
	}
	public static void requestError1(VolleyError error) {
		chefLoginListenner.defail(error);
	}
	
	//菜品
	public static void requestDone2(String theObject) {
		dishListenner.success(theObject);
	}
	public static void requestError2(VolleyError error) {
		dishListenner.defail(error);
	}
	
	//菜品的所有订单
	public static void requestDone3(String theObject) {
		alldishListenner.success(theObject);
	}
	public static void requestError3(VolleyError error) {
		alldishListenner.defail(error);
	}
	
	//订单修改
	public static void requestDone4(String theObject) {
		orderListenner.success(theObject);
	}
	public static void requestError4(VolleyError error) {
		orderListenner.defail(error);
	}
	
}
