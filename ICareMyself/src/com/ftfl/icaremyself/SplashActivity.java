package com.ftfl.icaremyself;

import com.ftfl.icaremyself.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Window;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/** Hiding Title bar of this activity screen */
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
		Thread background = new Thread() {
			public void run() {

				try {
					// Thread will sleep for 3 seconds
					sleep(2 * 1000);
					
					Intent i = new Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(i);

					/*if (!sPrefs.contains(FTFLConstants.KEY_PROFILE)) {
						Intent i = new Intent(SplashActivity.this,
								ProfileActivity.class);
						startActivity(i);
					} else {
						Intent i = new Intent(SplashActivity.this,
								HomeScreenActivity.class);
						startActivity(i);
					}*/
					// Remove activity
					finish(); // so that, it will not get back in the previous
								// file.

				} catch (Exception e) {

				}
			}
		};

		// start thread
		background.start();
	}

}
