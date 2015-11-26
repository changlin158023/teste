package com.tasteshared;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.tasteshared.fragment.BalanceFragment;
import com.tasteshared.fragment.GoodsFragment;

public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabhost;
	private int tab_imagelist[] = new int[] { R.drawable.tab_tag_selector,
			R.drawable.tab_tag_selector};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();// 初始化Tabhost
	}

	private void initUI() {
		mTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		AddTab("1", "订单", 0, GoodsFragment.class);
		AddTab("2", "我", 1, BalanceFragment.class);
	}

	private void AddTab(String tag, String title, int i,Class class1) {
		TabSpec tabSpec = mTabhost.newTabSpec(tag);
		View view = getLayoutInflater().inflate(R.layout.tabhost_item, null);
		ImageView tab_image = (ImageView) view.findViewById(R.id.tab_image);
		TextView tab_text = (TextView) view.findViewById(R.id.tab_name);
		tab_text.setText(title);
		tab_image.setImageResource(tab_imagelist[i]);
		mTabhost.addTab(tabSpec.setIndicator(view), class1, null);
	}

}
