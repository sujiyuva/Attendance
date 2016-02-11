package com.example.managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class ViewStudentlistatten extends Activity {
	ListView listView;
	String date1;
	String roll1 = "", name11 = "";
	int pos;
	ResultSet rs = null;
	ResultSet rs1 = null;
	Connection conn;

	HashMap<String, String> usersList1 = null;
	ArrayList<HashMap<String, String>> usersList2 = new ArrayList<HashMap<String, String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_studentlist);
		listView = (ListView) findViewById(R.id.listView222);

		Intent i = getIntent();
		// Intent i = getIntent();
		// date1 = getIntent().getExtras().getString("");
		// int temp = i.getIntExtra("pos", pos);

		// Log.d("student id  :",usersList1.toString());

		// Intent(ViewStudentlist.this, TakeAttendance.class);
		// intent.putExtra("pos", pos); startActivity(intent);

		new QuerySQL().execute();

	}

	public class QuerySQL extends AsyncTask<Object, Void, Boolean> {

		ProgressDialog pDialog;

		Exception error;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(ViewStudentlistatten.this);
			pDialog.setTitle("Attendance Details...");
			pDialog.setMessage("Getting Student List...");
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(Object... args) {
			// Integer pos = (Integer) args[0];

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
				// String
				// COMANDOSQL1="select * from services where reqsender='"+sendername+"' || reqrecv='"+sendername+"' && status='accept'";
				// Statement statement1 = conn.createStatement();

				// ResultSet rs1 = statement1.executeQuery(COMANDOSQL1);
				// if(rs1.next()){
				String COMANDOSQL = "select * from studentlist";
				Statement statement = conn.createStatement();
				rs = statement.executeQuery(COMANDOSQL);
				while (rs.next()) {
					usersList1 = new HashMap<String, String>();
					usersList1.put("name", rs.getString("name"));
					usersList1.put("name1", rs.getString("rollno"));
					usersList1.put("name2", rs.getString("dept"));
					// usersList1.put("name2",rs.getString("COmpanyname"));

					Log.d("Friend List Map :", usersList1.toString());

					usersList2.add(usersList1);

				}
				// }

				return true;
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

				listView.setAdapter(new CustomBaseAdapterjavaieeepapers(
						ViewStudentlistatten.this, usersList2));
				listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {

						pos = position;
						if (pos == 0) {

							Toast.makeText(getApplicationContext(),
									"Place Take Your Attendance Below",
									Toast.LENGTH_SHORT).show();

						} else {

							Toast.makeText(getApplicationContext(), "ok" + pos,
									Toast.LENGTH_SHORT).show();
							// Intent intent = getIntent();
							Intent i = new Intent(ViewStudentlistatten.this,
									TakeAttendance.class);
							String pos1 = "" + pos;
							i.putExtra("pos", pos1);
							String pos2 = "2";
							try {
								// String
								// COMANDOSQL1="select * from services where reqsender='"+sendername+"' || reqrecv='"+sendername+"' && status='accept'";
								// Statement statement1 =
								// conn.createStatement();

								// ResultSet rs1 =
								// statement1.executeQuery(COMANDOSQL1);
								// if(rs1.next()){
								String sql1 = "select * from studentlist WHERE id='"
										+ pos1 + " '";
								Statement s1 = conn.createStatement();
								rs1 = s1.executeQuery(sql1);
								while (rs1.next()) {
									// usersList1 = new HashMap<String,
									// String>();
									// usersList1.put("name",
									// rs.getString("name"));
									// usersList1.put("name1",
									// rs.getString("rollno"));
									// usersList1.put("name2",
									// rs.getString("dept"));
									// usersList1.put("name2",rs.getString("COmpanyname"));

									// Log.d("Friend List Map :",
									// usersList1.toString());

									// usersList2.add(usersList1);

									name11 = rs1.getString(2);
									roll1 = rs1.getString(3);

								}
								// }

								// Toast.makeText(getBaseContext(),
								// "Successfully Inserted.",
								// Toast.LENGTH_LONG).show();
							} catch (Exception e) {
								error = e;

								// Toast.makeText(getBaseContext(),"Successfully Registered...",
								// Toast.LENGTH_LONG).show();
							}
							// Log.d("student name :", name11);
							// i.putExtra("name", name11);
							// i.putExtra("rollno", roll1);

							startActivity(i);

						}
					}

				});

				// System.out.println("ELSE(JSON) LOOP EXE");
				try {// try3 open

				} catch (Exception e1) {
					Toast.makeText(getBaseContext(), e1.toString(),
							Toast.LENGTH_LONG).show();

				}

			} else {
				if (error != null) {
					Toast.makeText(getBaseContext(),
							error.getMessage().toString(), Toast.LENGTH_LONG)
							.show();
				}
			}
			super.onPostExecute(result1);
		}
	}

}
