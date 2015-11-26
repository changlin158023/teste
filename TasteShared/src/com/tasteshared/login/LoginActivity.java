package com.tasteshared.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.tasteshared.R;

public class LoginActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initUI();
	}

	private void initUI() {
		findViewById(R.id.Loginlogin).setOnClickListener(this);//µÇÂ¼
		findViewById(R.id.LoginRegistered).setOnClickListener(this);//×¢²á
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Loginlogin:
			Loginlogin();
			break;
		case R.id.LoginRegistered:
			LoginRegistered();
			break;
		default:
			break;
		}
	}

	private void LoginRegistered() {
		
	}

	private void Loginlogin() {
		Intent intent=new Intent(LoginActivity.this, EnterActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.in_item, R.anim.out_item);
	}

}
