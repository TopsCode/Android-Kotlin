package com.tops.WakeLockExample;

import android.os.Bundle;
import android.os.PowerManager;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {
	PowerManager pm;
	PowerManager.WakeLock wl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		if (pm != null) {
			wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "WakeLockExample:rushabh");
		}

		wl.acquire(10*60*1000L /*10 minutes*/);
		//...
		wl.release();
	}
}
