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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class ViewStudentlist2atten extends Activity {
	// ListView listView;
	EditText no1;
	TextView p, a, pr, on;
	Button check;
	String report = "", yes = "yes", no = "no", id1 = "0";
	int status, status2, presentdays, presentdays1, absents, onduty2;
	String present2, absent2, per2;
	double per;
	Connection conn;

	HashMap<String, String> usersList1 = null;
	ArrayList<HashMap<String, String>> usersList2 = new ArrayList<HashMap<String, String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student);
		// listView = (ListView) findViewById(R.id.listView222);
		check = (Button) findViewById(R.id.button1);
		no1 = (EditText) findViewById(R.id.editText1);

		p = (TextView) findViewById(R.id.textView2);
		a = (TextView) findViewById(R.id.textView3);
		pr = (TextView) findViewById(R.id.textView4);
		on = (TextView) findViewById(R.id.TextView01);

		check.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stu

				report = no1.getText().toString();

				// double per = (double) (status2 / status) * 100;

				new QuerySQL().execute();

			}
		});

	}

	public class QuerySQL extends AsyncTask<Object, Void, Boolean> {

		ProgressDialog pDialog;

		Exception error;

		ResultSet rs;
		ResultSet rs1;
		ResultSet rs2;
		ResultSet rs3;
		ResultSet rs4;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(ViewStudentlist2atten.this);
			pDialog.setTitle("Attendance Status...");
			pDialog.setMessage("Getting Student Status...");
			pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected Boolean doInBackground(Object... args) {

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

			// Log.d("student report :", report);

			try {
				// String
				// COMANDOSQL1="select * from services where reqsender='"+sendername+"' || reqrecv='"+sendername+"' && status='accept'";
				// Statement statement1 = conn.createStatement();

				// ResultSet rs1 = statement1.executeQuery(COMANDOSQL1);
				// if(rs1.next()){
				String COMANDOSQL = "select id from attendance where rollno='"
						+ report + "'";

				// String COMANDOSQL1 =
				// "select count (presentdays) from attendancestatus WHERE id='"
				// + report + " ' ";
				Statement statement = conn.createStatement();
				rs = statement.executeQuery(COMANDOSQL);

				if (rs.next()) {
					// usersList1 = new HashMap<String, String>();
					// usersList1.put("name", rs.getString("Rollno"));
					// usersList1.put("name1",
					// rs1.getString("Rollno,Presentdays"));
					// usersList1.put("name1", rs.getString("rollno"));
					// usersList1.put("name2", rs.getString("dept"));
					// usersList1.put("name2",rs.getString("COmpanyname"));

					// status = Integer.parseInt(rs.getString(1));

					// Log.d("student id :", rs.toString());
					id1 = rs.getString(1);

					// usersList2.add(usersList1);

				} else {

					Toast.makeText(getBaseContext(),
							"Enter Correct Roll Number", Toast.LENGTH_LONG)
							.show();
					return false;

				}

				Statement statement2 = conn.createStatement();
				String COMANDOSQL1 = "select count(presentdays) from attendancestatus WHERE id='"
						+ id1 + " ' ";
				rs1 = statement2.executeQuery(COMANDOSQL1);
				if (rs1.next()) {
					// usersList1 = new HashMap<String, String>();
					// usersList1.put("name", rs1.getString("Rollno"));
					// usersList1.put("name1",=
					// rs1.getString("Rollno,Presentdays"));
					// usersList1.put("name1", rs.getString("rollno"));
					// usersList1.put("name2", rs.getString("dept"));
					// usersList1.put("name2",rs.getString("COmpanyname"));

					// status2 = Integer.parseInt(rs1.getString(1));

					// usersList2.add(usersList1);

					// }
					// Log.d("status :", rs1.toString());
					presentdays = rs1.getInt(1);
					// }
					// Log.d("per :", per . getText().toString());

				}
				Statement statement3 = conn.createStatement();
				String COMANDOSQL2 = "select count(presentdays) from attendancestatus WHERE id='"
						+ id1 + " ' AND presentdays='" + yes + "' ";
				rs2 = statement3.executeQuery(COMANDOSQL2);

				if (rs2.next()) {
					// usersList1 = new HashMap<String, String>();
					// usersList1.put("name", rs1.getString("Rollno"));
					// usersList1.put("name1",=
					// rs1.getString("Rollno,Presentdays"));
					// usersList1.put("name1", rs.getString("rollno"));
					// usersList1.put("name2", rs.getString("dept"));
					// usersList1.put("name2",rs.getString("COmpanyname"));

					// status2 = Integer.parseInt(rs1.getString(1));

					// usersList2.add(usersList1);

					// }
					// Log.d("status :", rs1.toString());
					presentdays1 = rs2.getInt(1);
					// }

					// Log.d("per :", per . getText().toString());

				}
				Statement statement4 = conn.createStatement();
				String COMANDOSQL3 = "select count(presentdays) from attendancestatus WHERE id='"
						+ id1 + " ' AND presentdays='" + no + "' ";
				rs3 = statement4.executeQuery(COMANDOSQL3);

				if (rs3.next()) {
					// usersList1 = new HashMap<String, String>();
					// usersList1.put("name", rs1.getString("Rollno"));
					// usersList1.put("name1",=
					// rs1.getString("Rollno,Presentdays"));
					// usersList1.put("name1", rs.getString("rollno"));
					// usersList1.put("name2", rs.getString("dept"));
					// usersList1.put("name2",rs.getString("COmpanyname"));

					// status2 = Integer.parseInt(rs1.getString(1));

					// usersList2.add(usersList1);

					// }
					// Log.d("status :", rs1.toString());
					absents = rs3.getInt(1);
					// }

					// Log.d("per :", per . getText().toString());

				}
				// Statement statement5 = conn.createStatement();
				// String COMANDOSQL4 =
				// "select * from attendancestatus WHERE id='"
				// + id1 + " ' AND presentdays='" + yes + "' ";
				// rs4 = statement4.executeQuery(COMANDOSQL4);

				// if (rs4.next()) {
				// usersList1 = new HashMap<String, String>();
				// usersList1.put("name", rs1.getString("Rollno"));
				// usersList1.put("name1",=
				// rs1.getString("Rollno,Presentdays"));
				// usersList1.put("name1", rs.getString("rollno"));
				// usersList1.put("name2", rs.getString("dept"));
				// usersList1.put("name2",rs.getString("COmpanyname"));

				// status2 = Integer.parseInt(rs1.getString(1));

				// usersList2.add(usersList1);

				// }
				// // Log.d("status :", rs1.toString());
				// onduty2 = rs4.getInt(1);
				// }

				// Log.d("per :", per . getText().toString());

				// }
				//
				// Toast.makeText(getBaseContext(),
				// "Successfully Inserted.", Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				error = e;

				// Toast.makeText(getBaseContext(),"Enter Corrrect Roll Number",
				// s Toast.LENGTH_LONG).show();
			}
			return true;
		}

		@SuppressLint("NewApi")
		@Override
		protected void onPostExecute(Boolean result1) {
			pDialog.dismiss();
			if (result1) {

				// / listView.setAdapter(new CustomBaseAdapterjavaieeepapers2(
				// ViewStudentlist2.this, usersList2));

				// System.out.println("ELSE(JSON) LOOP EXE");
				try {// try3 open
						// double per = (double) (status2 / status) * 100;
					// Toast.makeText(getBaseContext(), "Yuor id1 %..." + id1,
					// Toast.LENGTH_LONG).show();

					// Toast.makeText(getBaseContext(),
					// "Yuor Presentdays..." + presentdays1,
					// Toast.LENGTH_LONG).show();
					// Toast.makeText(getBaseContext(),
					// "Yuor Absents..." + absents, Toast.LENGTH_LONG)
					// .show();

					// Intent next = new Intent(ViewStudentlist2.this,
					// Result.class);

					// Toast.makeText(getBaseContext(),
					// "Your Present Days..." + presentdays1,
					// Toast.LENGTH_LONG).show();

					// Toast.makeText(getBaseContext(),
					// "Your Absent Days..." + absents,
					// Toast.LENGTH_LONG).show();
					p.setText("Your Present Days is : " + presentdays1);

					a.setText("Your Absent Days is : " + absents);

					per = (double) ((double) ((double) presentdays1 / (double) presentdays) * 100);
					pr.setText("Your Percentage is  : % " + per);
					// on.setText("Your onduty Days is : " + onduty2);

					// Toast.makeText(getBaseContext(),
					// "Your Attendance Status %..." + per,
					// Toast.LENGTH_LONG).show();
					// Intent next = getIntent();
					// Bundle b = new Bundle();
					// next.putExtra("presentdays", present2);

					// next.putExtra("absents", absent2);
					// next.putExtra("per", per2);
					// next.putExtras(b);
					// startActivity(next);

					// Log.d("per :", per . getText().toString());

				}

				catch (Exception e1) {
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
