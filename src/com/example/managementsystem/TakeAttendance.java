package com.example.managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TakeAttendance extends Activity {
	String pos;

	// TextView name1, roll1;
	Button submit;
	String name, rollno;
	RadioButton present, absent, od;
	Connection conn;

	private String present1, absent1, od1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.takeattendance);

		// /roll1 = i.getStringExtra("roll1");

		// Log.d("stdent name :",stuname.toString());
		// Log.d("student rollno :",sturollno.toString());

		//

		// name1 = (TextView) findViewById(R.id.textView1);
		// roll1 = (TextView) findViewById(R.id.textView2);
		submit = (Button) findViewById(R.id.button1);
		present = (RadioButton) findViewById(R.id.radio1);
		absent = (RadioButton) findViewById(R.id.radio0);
		od = (RadioButton) findViewById(R.id.radio2);

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = getIntent();
				pos = getIntent().getExtras().getString("pos");
				// pos = i.getStringExtra("pos");
				// name = getIntent().getExtras().getString("name");
				// rollno = getIntent().getExtras().getString("rollno");
				Log.d("pos ststus  :", pos);
				// Log.d("pos ststus  :", name);
				// Log.d("pos ststus  :", rollno);
				if (present.isChecked()) {
					present1 = "yes";
					absent1 = "no";
					od1 = "no";

				} else if (absent.isChecked()) {
					present1 = "no";
					absent1 = "yes";
					od1 = "no";

				} else if (od.isChecked()) {
					present1 = "no";
					absent1 = "no";
					od1 = "yes";

				}

				else {
					Toast.makeText(getApplicationContext(), "Please Check",
							Toast.LENGTH_SHORT).show();

				}

				new QuerySQL().execute();

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

			pDialog = new ProgressDialog(TakeAttendance.this);
			pDialog.setTitle("Attendance Details");
			pDialog.setMessage("Storing your credentials...");
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(String... args) {
			// String poss = (String) args[0];
			// String stuname1 = (String) args[1];
			// String sturollno1 = (String) args[2];

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://103.10.235.57:3306/college", "root",
						"password");
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
						.executeUpdate("insert into attendancestatus values('"
								+ pos + "','" + present1 + "','" + absent1
								+ "','" + od1 + "')");

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

					Intent i = new Intent(getApplicationContext(),
							ViewStudentlist2.class);

					// startActivity(i);

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
