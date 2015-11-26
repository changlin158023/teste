package com.tasteshared.login;

import com.tasteshared.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RegisteredActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registered);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registered, menu);
		return true;
	}

}
