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
		findViewById(R.id.EnterBack).setOnClickListener(this);//����
		findViewById(R.id.EnterSendPhone).setOnClickListener(this);//���͵绰����
		findViewById(R.id.EnterSendCode).setOnClickListener(this);//������֤��
		mEnterEditPhone = (EditText) findViewById(R.id.EnterEditPhone);//����绰����
		mEnterBefore = (RelativeLayout) findViewById(R.id.EnterBefore);//����绰����֮ǰ����
		mEnterAfter = (RelativeLayout) findViewById(R.id.EnterAfter);//����绰����֮�󲼾�
		mEnterCustomerPhone = (TextView) findViewById(R.id.EnterCustomerPhone);//��ʾ�ͻ��ĵ绰����
		mEnterEditCode = (EditText) findViewById(R.id.EnterEditCode);//������֤��
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
