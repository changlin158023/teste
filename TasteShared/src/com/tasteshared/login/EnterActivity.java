package com.tasteshared.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
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
import com.tasteshared.Utils.Person;
import com.tasteshared.back.EnterBack;

public class EnterActivity extends Activity implements OnClickListener{

	private EditText mEnterEditPhone;
	private RelativeLayout mEnterBefore;
	private RelativeLayout mEnterAfter;
	private TextView mEnterCustomerPhone;
	private EditText mEnterEditCode;
	private EditText mEnterEditPassword;
	private Interface mEnterInterface;
	
	private String fileName = getSDPath() + "/" + "saveData";
	public String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
		// �ж�sd���Ƿ����
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// ��ȡ��Ŀ¼
		}
		return sdDir.toString();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		initUI();
		initInterface();
		initLogin();
	}

	private void initLogin() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person person = (Person) ois.readObject();
			String chefId = person.chefId;
			String password=person.password;
			Log.e("EnterActivity", "chefId==="+chefId);
			Log.e("EnterActivity", "password==="+password);
			if(!("".equals(chefId)&"".equals(password))){
				Chef chef=new Chef();
				chef.setPhone(chefId);
				chef.setPassword(password);
				mEnterInterface.chefLogin(EnterActivity.this, chef);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initInterface() {
		mEnterInterface = Interface.getInstance();
		//��¼����
		mEnterInterface.setPostListener(new ChefLoginListenner() {
			
			@Override
			public void success(String A) {
				Log.e("EnterActivity", "��¼���õĽ��==="+A);
				EnterBack enterBack=GsonUtils.parseJson(A, EnterBack.class);
				Integer status=enterBack.getStatusMsg();
				if(1==status){
					List<Chef> cheflist=enterBack.getReturnData();
					Chef chef=cheflist.get(0);
					TheParameter.setChef(chef);
					String chefId=chef.getPhone();
					String chefPassword=chef.getPassword();
					Intent intent=new Intent(EnterActivity.this, MainActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.in_item, R.anim.out_item);
					finish();
					
					Person person = new Person(chefId,chefPassword);
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
						oos.writeObject(person);
						oos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}else {
					//�Զ���Toast
					View toastRoot = getLayoutInflater().inflate(R.layout.my_error_toast, null);
					Toast toast=new Toast(getApplicationContext());
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.setView(toastRoot);
					toast.setDuration(100);
					TextView tv=(TextView)toastRoot.findViewById(R.id.TextViewInfo);
					tv.setText("\n"+"      ��¼ʧ��!"+"\n"+"\n"+"�˻����������!");
					toast.show();
				}
			}
			
			@Override
			public void defail(Object B) {
				
			}
		});
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
		mEnterEditPassword = (EditText) findViewById(R.id.EnterEditPassword);//��������
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
