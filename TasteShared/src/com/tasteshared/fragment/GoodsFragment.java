package com.tasteshared.fragment;

import java.util.ArrayList;
import java.util.List;

import com.github.volley_examples.utils.GsonUtils;
import com.tasteshared.IConstant;
import com.tasteshared.Interface;
import com.tasteshared.TheParameter;
import com.tasteshared.Interface.DishListenner;
import com.tasteshared.R;
import com.tasteshared.back.DishBack;
import com.tasteshared.function.GoodsDetailsActivity;
import com.tasteshared.javabean.Chef;
import com.tasteshared.javabean.DishBackMessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class GoodsFragment extends Fragment {

	private View mLayout;
	private ListView mGoodsListView;
	private Interface mGoodsInterface;
	private List<DishBackMessage> DishList=new ArrayList<DishBackMessage>();

	public GoodsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(mLayout==null){
			mLayout = inflater.inflate(R.layout.fragment_goods, container, false);
			initUI();
			initInterface();
			initChefDish();//读取厨师会做的菜品
		}
		return mLayout;
	}

	private void initChefDish() {
		Chef chef=TheParameter.getChef();
		mGoodsInterface.dishing(getActivity(), chef);
	}

	private void initInterface() {
		mGoodsInterface = Interface.getInstance();
		//厨师菜品监听
		mGoodsInterface.setPostListener(new DishListenner() {
			
			@Override
			public void success(String A) {
				Log.e("GoodsFragment", "厨师的所有菜品==="+A);
				DishList.clear();
				DishBack dishBack=GsonUtils.parseJson(A, DishBack.class);
				Integer status=dishBack.getStatusMsg();
				if(1==status){
					List<DishBackMessage> DishBackMessagesList=dishBack.getReturnData();
					for (int i = 0; i < DishBackMessagesList.size(); i++) {
						DishBackMessage backMessage=DishBackMessagesList.get(i);
						DishList.add(backMessage);
					}
				}
			}
			
			@Override
			public void defail(Object B) {
				
			}
		});
	}

	private void initUI() {
		mGoodsListView = (ListView) mLayout.findViewById(R.id.GoodsListView);
		MyGoodsAdapter adapter=new MyGoodsAdapter();
		mGoodsListView.setAdapter(adapter);
		mGoodsListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				DishBackMessage backMessage=DishList.get(position);
				Intent intent=new Intent(getActivity(), GoodsDetailsActivity.class);
				intent.putExtra(IConstant.DishBackMessage, backMessage);
				startActivity(intent);
				getActivity().overridePendingTransition(R.anim.in_item, R.anim.out_item);
			}
		});
	}

	class ViewHolder{
		RelativeLayout GoodsComplete;
		TextView GoodsName;
		TextView GoodsNumbers;
		TextView GoodsHasCompletedNumbers;
		TextView GoodsUnfinishedNumbers;
	}
	
	class MyGoodsAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return DishList.size();
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
				LayoutInflater layoutInflater = getActivity().getLayoutInflater();
				inflater=layoutInflater.inflate(R.layout.goods_item, null);
				holder.GoodsComplete=(RelativeLayout) inflater.findViewById(R.id.GoodsComplete);
				holder.GoodsName=(TextView) inflater.findViewById(R.id.GoodsName);
				holder.GoodsNumbers=(TextView) inflater.findViewById(R.id.GoodsNumbers);
				holder.GoodsHasCompletedNumbers=(TextView) inflater.findViewById(R.id.GoodsHasCompletedNumbers);
				holder.GoodsUnfinishedNumbers=(TextView) inflater.findViewById(R.id.GoodsUnfinishedNumbers);
				inflater.setTag(holder);
			}else {
				inflater=convertView;
				holder=(ViewHolder) inflater.getTag();
			}
			
			DishBackMessage backMessage=DishList.get(position);
			holder.GoodsName.setText(backMessage.getName());
			
			return inflater;
		}
		
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ViewGroup parent = (ViewGroup) mLayout.getParent();
		parent.removeView(mLayout);
	}
}
