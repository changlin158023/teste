package com.tasteshared.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tasteshared.R;

public class EnterActivity extends Activity implements OnClickListener{

	private EditText mEnterEditPhone;
	private RelativeLayout mEnterBefore;
	private RelativeLayout mEnterAfter;
	private TextView mEnterCustomerPhone;
	private EditText mEnterEditCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		initUI();
	}

	private void initUI() {
		findViewById(R.id.EnterBack).setOnClickListener(this);//返回
		findViewById(R.id.EnterSendPhone).setOnClickListener(this);//发送电话号码
		findViewById(R.id.EnterSendCode).setOnClickListener(this);//发送验证码
		mEnterEditPhone = (EditText) findViewById(R.id.EnterEditPhone);//输入电话号码
		mEnterBefore = (RelativeLayout) findViewById(R.id.EnterBefore);//输入电话号码之前布局
		mEnterAfter = (RelativeLayout) findViewById(R.id.EnterAfter);//输入电话号码之后布局
		mEnterCustomerPhone = (TextView) findViewById(R.id.EnterCustomerPhone);//显示客户的电话号码
		mEnterEditCode = (EditText) findViewById(R.id.EnterEditCode);//输入验证码
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.EnterBack:
			EnterBack();
			break;

		default:
			break;
		}
	}

	private void EnterBack() {
		finish();
	}

}
