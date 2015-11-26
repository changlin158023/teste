package com.tasteshared.fragment;

import com.tasteshared.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

	public GoodsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(mLayout==null){
			mLayout = inflater.inflate(R.layout.fragment_goods, container, false);
			initUI();
		}
		return mLayout;
	}

	private void initUI() {
		mGoodsListView = (ListView) mLayout.findViewById(R.id.GoodsListView);
		MyGoodsAdapter adapter=new MyGoodsAdapter();
		mGoodsListView.setAdapter(adapter);
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
			return 0;
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
