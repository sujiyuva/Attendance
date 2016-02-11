package com.example.managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	EditText edtName, edtMobileNo, edtEmail, edtRollNo, edtPassword, edtip;
	Button btnSubmit, btnSubmit1;
	Connection conn;

	private String name, mobilenumber, email, rollno, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		edtName = (EditText) findViewById(R.id.edtname);
		edtRollNo = (EditText) findViewById(R.id.edtrollno);
		edtEmail = (EditText) findViewById(R.id.edtmailid);
		edtPassword = (EditText) findViewById(R.id.edtpassword1);
		edtMobileNo = (EditText) findViewById(R.id.mobile);

		btnSubmit = (Button) findViewById(R.id.btntosubmit);
		btnSubmit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				name = edtName.getText().toString();
				rollno = edtRollNo.getText().toString();
				email = edtEmail.getText().toString();
				password = edtPassword.getText().toString();
				mobilenumber = edtMobileNo.getText().toString();
				// ipaddress = edtip.getText().toString();
				try {
					new QuerySQL().execute();

				} catch (Exception e) {
					Log.e("ERRO", e.getMessage());
				}

			}
		});

	}

	public class QuerySQL extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pDialog;
		Exception error;
		ResultSet rs;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(LoginActivity.this);
			pDialog.setTitle("Registration");
			pDialog.setMessage("Registering your credentials...");
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(String... args) {

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://103.10.235.57/College", "root", "password");
			} catch (SQLException se) {
				Log.e("ERRO1", se.getMessage());
			} catch (ClassNotFoundException e) {
				Log.e("ERRO2", e.getMessage());
			} catch (Exception e) {
				Log.e("ERRO3", e.getMessage());
			}

			try {
				Statement statement = conn.createStatement();
				int success = statement
						.executeUpdate("insert into register values('" + name
								+ "','" + rollno + "','" + email + "','"
								+ password + "','" + mobilenumber + "')");

				if (success >= 1) {
					// successfully created product

					return true;
					// closing this screen
					// finish();
				} else {
					// failed to create product
					return false;
				}

				// Toast.makeText(getBaseContext(),
				// "Successfully Inserted.", Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				error = e;
				return false;
				// Toast.makeText(getBaseContext(),"Successfully Registered...",
				// Toast.LENGTH_LONG).show();
			}

		}

		@SuppressLint("NewApi")
		@Override
		protected void onPostExecute(Boolean result1) {
			pDialog.dismiss();
			if (result1) {

				Toast.makeText(getBaseContext(),
						"Successfully created your credentials.",
						Toast.LENGTH_LONG).show();

				// System.out.println("ELSE(JSON) LOOP EXE");
				try {// try3 open

					Intent i = new Intent(getApplicationContext(), Signin.class);
					startActivity(i);

				} catch (Exception e1) {
					Toast.makeText(getBaseContext(), e1.toString(),
							Toast.LENGTH_LONG).show();

				}

			} else {
				if (error != null) {
					Toast.makeText(getApplicationContext(), error.toString(),
							Toast.LENGTH_LONG).show();
					Log.d("Error not null...", error.toString());
				} else {
					Toast.makeText(getBaseContext(),
							"Not crreated your credentials!!!",
							Toast.LENGTH_LONG).show();
				}
			}
			super.onPostExecute(result1);
		}
	}

}
