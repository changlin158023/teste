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
	
	// ��ʦ��¼
	String kCheflogin = "5";
	//��Ʒ
	String kDishs = "2";
	//��Ʒ�����ж���
	String kAllDishs = "6";
	//�����޸�
	String kOrder = "7";
	
	
	
	//��ͨ
	public Map<String, String> packParams(Object classObject,
			String interfaceType) {
		Map map = Bean2Map.ConvertObjToMap(classObject);
		Log.e("Interface", "map------" + map);
		JSONObject jsonObject = new JSONObject(map);
		Map<String, String> params = new HashMap<String, String>();

		params.put("request_type", interfaceType);
		Log.e("Interface", "�� ���json:" + jsonObject.toString());
		params.put("request_data", jsonObject.toString());

		return params;
	}
	
	
	
	
	//��ʦ��¼	
	private void ChefLoginPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError1(error);
				Log.e("ʧ��", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone1(response);
			}
		});
	}
	
	//��Ʒ
	private void DishPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError2(error);
				Log.e("ʧ��", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone2(response);
			}
		});
	}
	
	//��Ʒ�����ж���
	private void AllDishPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError3(error);
				Log.e("ʧ��", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone3(response);
			}
		});
	}
	
	//�����޸�
	private void OrderPost(Context context, Map<String, String> params) {
		
		MyVolley.post(context, url, params, new VolleyListenner() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				requestError4(error);
				Log.e("ʧ��", "" + error);
			}
			
			@Override
			public void onResponse(String response) {
				requestDone4(response);
			}
		});
	}
	
	
	
	
	
	// ��ʦ��¼
	public void chefLogin(Context context, Chef chef) {
		ChefLoginPost(context, packParams(chef, kCheflogin));
	}
	// ��Ʒ
	public void dishing(Context context, Chef chef) {
		DishPost(context, packParams(chef, kDishs));
	}
	// ��Ʒ�����Զ���
	public void Alldishing(Context context, Dish dish) {
		AllDishPost(context, packParams(dish, kAllDishs));
	}
	// �����޸�
	public void odering(Context context, Order order) {
		OrderPost(context, packParams(order, kOrder));
	}
	
	
	
	// ��ʦ��¼
	private static ChefLoginListenner chefLoginListenner;
	// ��Ʒ
	private static DishListenner dishListenner;
	// ��Ʒ�����ж���
	private static AllDishListenner alldishListenner;
	// �����޸�
	private static OrderListenner orderListenner;
	
	
	
	
	// ��ʦ��¼
	public interface ChefLoginListenner {
		void success(String A);
		
		void defail(Object B);
	}
	// ��Ʒ
	public interface DishListenner {
		void success(String A);
		
		void defail(Object B);
	}
	// ��Ʒ�����ж���
	public interface AllDishListenner {
		void success(String A);
		
		void defail(Object B);
	}
	// �����޸�
	public interface OrderListenner {
		void success(String A);
		
		void defail(Object B);
	}
	
	
	
	
	//��ʦ��¼
	public void setPostListener(ChefLoginListenner listener) {
		this.chefLoginListenner = listener;
	}
	//��Ʒ
	public void setPostListener(DishListenner listener) {
		this.dishListenner = listener;
	}
	//��Ʒ�����ж���
	public void setPostListener(AllDishListenner listener) {
		this.alldishListenner = listener;
	}
	//�����޸�
	public void setPostListener(OrderListenner listener) {
		this.orderListenner = listener;
	}
	
	
	
	
	
	//��ʦ��¼
	public static void requestDone1(String theObject) {
		chefLoginListenner.success(theObject);
	}
	public static void requestError1(VolleyError error) {
		chefLoginListenner.defail(error);
	}
	
	//��Ʒ
	public static void requestDone2(String theObject) {
		dishListenner.success(theObject);
	}
	public static void requestError2(VolleyError error) {
		dishListenner.defail(error);
	}
	
	//��Ʒ�����ж���
	public static void requestDone3(String theObject) {
		alldishListenner.success(theObject);
	}
	public static void requestError3(VolleyError error) {
		alldishListenner.defail(error);
	}
	
	//�����޸�
	public static void requestDone4(String theObject) {
		orderListenner.success(theObject);
	}
	public static void requestError4(VolleyError error) {
		orderListenner.defail(error);
	}
	
}
