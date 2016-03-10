package com.example.deals;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.media.MediaPlayer;//for sound
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


	private static int SPLASH_TIME_OUT=3000;
	String Userid,Pw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MediaPlayer mySound = MediaPlayer.create(MainActivity.this, R.raw.welcome);
		mySound.start();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				Intent it = new Intent(MainActivity.this, checkuser.class);
				startActivity(it);
				finish();
				if (!checkpref()) {
					//Toast.makeText(getApplicationContext(),"No User",Toast.LENGTH_LONG).show();
					/*Intent it = new Intent(MainActivity.this, checkuser.class);
					startActivity(it);*/

				} else {
					//Toast.makeText(getApplicationContext(),"User Exists"+Userid,Toast.LENGTH_LONG).show();
				}

			}
		}, SPLASH_TIME_OUT);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	public boolean checkpref()
	{

		SharedPreferences sharedpref= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
		/*SharedPreferences.Editor editor=sharedpref.edit();*/
		if(sharedpref.contains("UserId"))
		{

			Userid=sharedpref.getString("UserId","");



				return true;



		}
		else
		{
			return false;
		}


	}

}

