package com.example.managementsystem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Thread thread = new Thread() {

			public void run() {
				try {
					synchronized (this) {

						sleep(3000);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				finally {
					Intent intent = new Intent(MainActivity.this, Login.class);
					startActivity(intent);
				}
			}

		};
		thread.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
