package com.example.managementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity {

	Button admin, staff, stu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		admin = (Button) findViewById(R.id.button1);
		staff = (Button) findViewById(R.id.button2);
		stu = (Button) findViewById(R.id.button3);

		admin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, Signin.class);

				startActivity(intent);
			}
		});
		staff.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, Signinstaff.class);

				startActivity(intent);
			}
		});
		stu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, Signinstudent.class);

				startActivity(intent);
			}
		});

	}
}