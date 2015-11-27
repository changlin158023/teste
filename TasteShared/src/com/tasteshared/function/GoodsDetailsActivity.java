package com.tasteshared.function;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.tasteshared.IConstant;
import com.tasteshared.Interface;
import com.tasteshared.R;
import com.tasteshared.javabean.Dish;
import com.tasteshared.javabean.DishBackMessage;

public class GoodsDetailsActivity extends Activity {

	private TextView mGoodsDetailsUserName;
	private TextView mGoodsDetailsUserPhone;
	private TextView mGoodsDetailsUserAddress;
	private TextView mGoodsDetailsTransportTime;
	private Interface mGoodsDetailsInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_details);
		Intent intent = getIntent();
		DishBackMessage backMessage=(DishBackMessage) intent.getSerializableExtra(IConstant.DishBackMessage);
		initUI();
		initInterface();
		initDish(backMessage);
	}

	private void initInterface() {
		mGoodsDetailsInterface = Interface.getInstance();
	}

	private void initDish(DishBackMessage backMessage) {
		Dish dish=new Dish();
		dish.setPk_dish(backMessage.getPk_dish());
	}

	private void initUI() {
		mGoodsDetailsUserName = (TextView) findViewById(R.id.GoodsDetailsUserName);//订单用户名称
		mGoodsDetailsUserPhone = (TextView) findViewById(R.id.GoodsDetailsUserPhone);//订单用户的电话
		mGoodsDetailsUserAddress = (TextView) findViewById(R.id.GoodsDetailsUserAddress);//订单用户的送货地址
		mGoodsDetailsTransportTime = (TextView) findViewById(R.id.GoodsDetailsTransportTime);//订单送达时间
	}

}
