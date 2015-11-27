package com.tasteshared.login;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.volley_examples.utils.GsonUtils;
import com.tasteshared.IConstant;
import com.tasteshared.Interface;
import com.tasteshared.Interface.ChefLoginListenner;
import com.tasteshared.MainActivity;
import com.tasteshared.R;
import com.tasteshared.TheParameter;
import com.tasteshared.fragment.GoodsFragment;
import com.tasteshared.javabean.Chef;
import com.tasteshared.back.EnterBack;

public class EnterActivity extends Activity implements OnClickListener{

	private EditText mEnterEditPhone;
	private RelativeLayout mEnterBefore;
	private RelativeLayout mEnterAfter;
	private TextView mEnterCustomerPhone;
	private EditText mEnterEditCode;
	private EditText mEnterEditPassword;
	private Interface mEnterInterface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		initUI();
		initInterface();
	}

	private void initInterface() {
		mEnterInterface = Interface.getInstance();
		//登录监听
		mEnterInterface.setPostListener(new ChefLoginListenner() {
			
			@Override
			public void success(String A) {
				Log.e("EnterActivity", "登录后获得的结果==="+A);
				EnterBack enterBack=GsonUtils.parseJson(A, EnterBack.class);
				Integer status=enterBack.getStatusMsg();
				if(1==status){
					List<Chef> cheflist=enterBack.getReturnData();
					Chef chef=cheflist.get(0);
					TheParameter.setChef(chef);
					Intent intent=new Intent(EnterActivity.this, MainActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.in_item, R.anim.out_item);
					finish();
				}else {
					//自定义Toast
					View toastRoot = getLayoutInflater().inflate(R.layout.my_error_toast, null);
					Toast toast=new Toast(getApplicationContext());
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.setView(toastRoot);
					toast.setDuration(100);
					TextView tv=(TextView)toastRoot.findViewById(R.id.TextViewInfo);
					tv.setText("\n"+"      登录失败!"+"\n"+"\n"+"账户或密码错误!");
					toast.show();
				}
			}
			
			@Override
			public void defail(Object B) {
				
			}
		});
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
		mEnterEditPassword = (EditText) findViewById(R.id.EnterEditPassword);//输入密码
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.EnterBack:
			EnterBack();
			break;
		case R.id.EnterSendPhone:
			EnterSendPhone();
			break;
		default:
			break;
		}
	}

	private void EnterSendPhone() {
		String phone=mEnterEditPhone.getText().toString().trim();
		String password=mEnterEditPassword.getText().toString().trim();
		Chef chef=new Chef();
		chef.setPhone(phone);
		chef.setPassword(password);
		mEnterInterface.chefLogin(EnterActivity.this, chef);
	}

	private void EnterBack() {
		finish();
	}

}
