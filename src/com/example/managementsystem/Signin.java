package com.example.managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends Activity {

	Connection conn;
	EditText username, password, hostIP;
	Button signin, signup;
	String user, pass, user1, pass1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin);
		signin = (Button) findViewById(R.id.btntologin22);
		// signup = (Button) findViewById(R.id.btntoregister22);

		username = (EditText) findViewById(R.id.edtusername22);
		password = (EditText) findViewById(R.id.edtpassword22);
		// conn=CONN();
		signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				user = username.getText().toString();
				pass = password.getText().toString();
				Log.d("username", user);
				Log.d("password", pass);
				// startActivity(new Intent(Signin.this,Menu.class));
				// startActivity(new
				// Intent(MainActivity.this,LoginActivity.class));

				new QuerySQL().execute(user, pass);

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

			pDialog = new ProgressDialog(Signin.this);
			pDialog.setTitle("Authentication");
			pDialog.setMessage("Verifying your credentials...");
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(String... args) {

			user1 = new String(args[0]);
			pass1 = new String(args[1]);

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://103.10.235.57/college", "root",
						"password");
			} catch (SQLException se) {
				Log.e("ERRO1", se.getMessage());
			} catch (ClassNotFoundException e) {
				Log.e("ERRO2", e.getMessage());
			} catch (Exception e) {
				Log.e("ERRO3", e.getMessage());
			}

			try {
				String COMANDOSQL = "select * from register where name='"
						+ user1 + "' && password='" + pass1 + "'";
				Statement statement = conn.createStatement();
				rs = statement.executeQuery(COMANDOSQL);
				if (rs.next()) {

					return true;
				}

				return false;

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

				// System.out.println("ELSE(JSON) LOOP EXE");
				try {// try3 open

					Intent intent = new Intent(Signin.this, Sem.class);

					startActivity(intent);

				} catch (Exception e1) {
					Toast.makeText(getBaseContext(), e1.toString(),
							Toast.LENGTH_LONG).show();

				}

			} else {
				if (error != null) {
					Toast.makeText(getBaseContext(),
							error.getMessage().toString(), Toast.LENGTH_LONG)
							.show();
				} else {
					Toast.makeText(getBaseContext(),
							"Check your credentials!!!", Toast.LENGTH_LONG)
							.show();
				}
			}
			super.onPostExecute(result1);
		}
	}

}
