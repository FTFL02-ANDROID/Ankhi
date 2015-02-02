package com.ftfl.healthcare;

import com.ftfl.healthcare.database.HealthDBSource;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {

    HealthDBSource mDataSource = null;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        mDataSource = new HealthDBSource(this);
        
        Thread background = new Thread() {
			public void run() {

				try {
					// Thread will sleep for 3 seconds
					sleep(2 * 1000);

					// After 2 seconds redirect to another intent
					// Intent i=new
					// Intent(getBaseContext(),FTFLICareProfileActivity.class);

					// Bellow code will do the same thing....
					
					if(mDataSource.isEmpty())
					{
						Intent i = new Intent(SplashActivity.this, CreateProfileActivity.class);
						startActivity(i);
					}
					else{
						Intent i = new Intent( SplashActivity.this,	ViewProfileActivity.class );
						startActivity(i);
					}
					
				
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
