package com.paxw.demolist.customview.heartview;


import android.app.Activity;

import android.os.Bundle;
import android.util.Log;


public class HeartActivity extends Activity {

	/** Called when the activity is first created. */

	private HeartView love;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		this.love = new HeartView(this);

		setContentView(love);
		Log.e("life", "onCreate");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e("life", "onRestart");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e("life", "onResume");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e("life", "onPause");
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e("life", "onStop");
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("life", "onStart");
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e("life", "onDestroy");
	}
}
