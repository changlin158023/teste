package com.tasteshared.function;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.volley_examples.utils.GsonUtils;
import com.tasteshared.IConstant;
import com.tasteshared.Interface;
import com.tasteshared.Interface.AllDishListenner;
import com.tasteshared.Interface.OrderListenner;
import com.tasteshared.R;
import com.tasteshared.back.ChooseWayBack;
import com.tasteshared.back.DishDetailsBack;
import com.tasteshared.javabean.Dish;
import com.tasteshared.javabean.DishBackMessage;
import com.tasteshared.javabean.DishDetailsBackMessage;
import com.tasteshared.javabean.Order;

public class GoodsDetailsActivity extends Activity implements OnClickListener{

	private Interface mGoodsDetailsInterface;
	private List<DishDetailsBackMessage>  DishDetailsList=new ArrayList<DishDetailsBackMessage>();
	private TextView mGoodsDetailsNumbersText;
	private ListView mGoodsDetailsListView;
	private MyGoodsDetailsAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_details);
		Intent intent = getIntent();
		DishBackMessage backMessage=(DishBackMessage) intent.getSerializableExtra(IConstant.DishBackMessage);
		initUI(backMessage);
		initInterface();
		initDish(backMessage);
	}

	private void initInterface() {
		mGoodsDetailsInterface = Interface.getInstance();
		//�����ļ���
		mGoodsDetailsInterface.setPostListener(new AllDishListenner() {
			
			@Override
			public void success(String A) {
				Log.e("GoodsDetailsActivity", "��ȡ�������ж�����Ʒ==="+A);
				DishDetailsBack dishDetailsBack=GsonUtils.parseJson(A, DishDetailsBack.class);
				Integer status=dishDetailsBack.getStatusMsg();
				if(1==status){
					List<DishDetailsBackMessage> dishDetailsBackMessagesList=dishDetailsBack.getReturnData();
					if(dishDetailsBackMessagesList.size()>0){
						for (int i = 0; i < dishDetailsBackMessagesList.size(); i++) {
							DishDetailsBackMessage detailsBackMessage=dishDetailsBackMessagesList.get(i);
							DishDetailsList.add(detailsBackMessage);
						}
						adapter.notifyDataSetChanged();
					}
				}
			}
			
			@Override
			public void defail(Object B) {
				
			}
		});
		
		//�ӵ�����
		mGoodsDetailsInterface.setPostListener(new OrderListenner() {
			
			@Override
			public void success(String A) {
				Log.e("GoodsDetailsActivity", "�Ƿ��Ѿ��ӵ�==="+A);
				ChooseWayBack chooseWayBack=GsonUtils.parseJson(A, ChooseWayBack.class);
				Integer status=chooseWayBack.getStatusMsg();
				if(1==status){
					SharedPreferences ChooseWay_sp=getSharedPreferences(IConstant.ChooseWayBack, 0);
					Editor ChooseWay_editor=ChooseWay_sp.edit();
					ChooseWay_editor.putBoolean(IConstant.IsChooseWayBack, true);
					ChooseWay_editor.commit();
				}
				adapter.notifyDataSetChanged();
			}
			
			@Override
			public void defail(Object B) {
				
			}
		});
	}
	
	private void initDish(DishBackMessage backMessage) {
		Dish dish=new Dish();
		dish.setPk_dish(backMessage.getPk_dish());
		dish.setDesc("");
		dish.setPrice(backMessage.getPrice());
		dish.setAdd_time(backMessage.getAdd_time());
		dish.setType(backMessage.getType());
		dish.setRating(backMessage.getRating());
		dish.setFk_chef(backMessage.getFk_chef());
		dish.setEnable(backMessage.getEnable());
		mGoodsDetailsInterface.Alldishing(GoodsDetailsActivity.this, dish);
	}

	private void initUI(DishBackMessage backMessage) {
		findViewById(R.id.GoodsDetailsBack).setOnClickListener(this);//����
		mGoodsDetailsListView = (ListView) findViewById(R.id.GoodsDetailsListView);
		mGoodsDetailsNumbersText = (TextView) findViewById(R.id.GoodsDetailsNumbersText);//�ܷ���
		adapter = new MyGoodsDetailsAdapter();
		mGoodsDetailsListView.setAdapter(adapter);
		Integer unorder=backMessage.getunOrders();
		mGoodsDetailsNumbersText.setText(unorder+"��");
	}

	class ViewHolder{
		TextView GoodsDetailsUserName;
		TextView GoodsDetailsUserPhone;
		TextView GoodsDetailsUserAddress;
		TextView GoodsDetailsTransportTime;
		LinearLayout GoodsDetailsChooseWay;
		RelativeLayout GoodsDetailsComplete;
		RelativeLayout GoodsDetailsOrder;
		RelativeLayout GoodsDetailsCancleOrder;
		RelativeLayout GoodsDetailsWaitingForThePickup;
		ImageView GoodsDetailsCancle;
	}
	
	class MyGoodsDetailsAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return DishDetailsList.size();
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View inflater=null;
			ViewHolder holder=null;
			if(convertView==null){
				holder=new ViewHolder();
				LayoutInflater layoutInflater = getLayoutInflater();
				inflater=layoutInflater.inflate(R.layout.goodsdetails_item, null);
				holder.GoodsDetailsUserName = (TextView) inflater.findViewById(R.id.GoodsDetailsUserName);//�����û�����
				holder.GoodsDetailsUserPhone = (TextView) inflater.findViewById(R.id.GoodsDetailsUserPhone);//�����û��ĵ绰
				holder.GoodsDetailsUserAddress = (TextView) inflater.findViewById(R.id.GoodsDetailsUserAddress);//�����û����ͻ���ַ
				holder.GoodsDetailsTransportTime = (TextView) inflater.findViewById(R.id.GoodsDetailsTransportTime);//�����ʹ�ʱ��
				holder.GoodsDetailsChooseWay = (LinearLayout) inflater.findViewById(R.id.GoodsDetailsChooseWay);//ѡ��ʽ
				holder.GoodsDetailsComplete = (RelativeLayout) inflater.findViewById(R.id.GoodsDetailsComplete);//�������
				holder.GoodsDetailsOrder=(RelativeLayout) inflater.findViewById(R.id.GoodsDetailsOrder);//ȷ�Ͻӵ�
				holder.GoodsDetailsCancleOrder=(RelativeLayout) inflater.findViewById(R.id.GoodsDetailsCancleOrder);//ȡ���ӵ�
				holder.GoodsDetailsWaitingForThePickup=(RelativeLayout) inflater.findViewById(R.id.GoodsDetailsWaitingForThePickup);//�ȴ�ȡ��
				holder.GoodsDetailsCancle = (ImageView) inflater.findViewById(R.id.GoodsDetailsCancle);
				inflater.setTag(holder);
			}else {
				inflater=convertView;
				holder=(ViewHolder) inflater.getTag();
			}
			
			DishDetailsBackMessage backMessage=DishDetailsList.get(position);
			holder.GoodsDetailsUserName.setText("��ϵ��:   "+backMessage.getContacts());
			holder.GoodsDetailsUserPhone.setText("��ϵ�绰:   "+backMessage.getPhone());
			holder.GoodsDetailsUserAddress.setText("�ջ���ַ:   "+backMessage.getAddress());
			holder.GoodsDetailsTransportTime.setText("�ʹ�ʱ��:   "+backMessage.getArrival_time());
			
			Integer process=backMessage.getProcess();
			switch (process) {
			case 0:
				holder.GoodsDetailsChooseWay.setVisibility(View.VISIBLE);
				holder.GoodsDetailsComplete.setVisibility(View.GONE);
				holder.GoodsDetailsCancle.setVisibility(View.GONE);
				break;
			case 1:
				holder.GoodsDetailsChooseWay.setVisibility(View.GONE);
				holder.GoodsDetailsComplete.setVisibility(View.VISIBLE);
				holder.GoodsDetailsCancle.setVisibility(View.GONE);
				break;
			case 2:
				holder.GoodsDetailsCancle.setVisibility(View.VISIBLE);
				holder.GoodsDetailsOrder.setEnabled(false);
				holder.GoodsDetailsCancleOrder.setEnabled(false);
				break;
			case 3:
				holder.GoodsDetailsChooseWay.setVisibility(View.GONE);
				holder.GoodsDetailsWaitingForThePickup.setVisibility(View.VISIBLE);
				holder.GoodsDetailsCancle.setVisibility(View.GONE);
				break;
			default:
				break;
			}
			
			GoodsDetailsClick(holder,backMessage);
			return inflater;
		}

		private void GoodsDetailsClick(final ViewHolder holder, final DishDetailsBackMessage backMessage) {
			//ȷ�Ͻӵ�
			holder.GoodsDetailsOrder.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Order order=new Order();
					order.setPk_order(backMessage.getPk_order());
					order.setFk_user(backMessage.getFk_user());
					order.setFk_dish(backMessage.getFk_dish());
					order.setFk_chef(backMessage.getFk_chef());
					order.setProcess(1);
					mGoodsDetailsInterface.odering(GoodsDetailsActivity.this, order);
					holder.GoodsDetailsChooseWay.setVisibility(View.GONE);
					holder.GoodsDetailsComplete.setVisibility(View.VISIBLE);
				}
			});
			
			//ȡ���ӵ�
			holder.GoodsDetailsCancleOrder.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Order order=new Order();
					order.setPk_order(backMessage.getPk_order());
					order.setFk_user(backMessage.getFk_user());
					order.setFk_dish(backMessage.getFk_dish());
					order.setFk_chef(backMessage.getFk_chef());
					order.setProcess(2);
					mGoodsDetailsInterface.odering(GoodsDetailsActivity.this, order);
				}
			});
			
			//�������
			holder.GoodsDetailsComplete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Order order=new Order();
					order.setPk_order(backMessage.getPk_order());
					order.setFk_user(backMessage.getFk_user());
					order.setFk_dish(backMessage.getFk_dish());
					order.setFk_chef(backMessage.getFk_chef());
					order.setProcess(3);
					mGoodsDetailsInterface.odering(GoodsDetailsActivity.this, order);
					holder.GoodsDetailsComplete.setVisibility(View.GONE);
					holder.GoodsDetailsWaitingForThePickup.setVisibility(View.VISIBLE);
				}
			});
		}
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.GoodsDetailsBack:
			GoodsDetailsBack();
			break;

		default:
			break;
		}
	}

	private void GoodsDetailsBack() {
		finish();
	}

}
