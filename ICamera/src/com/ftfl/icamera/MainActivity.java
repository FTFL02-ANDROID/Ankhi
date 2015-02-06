package com.ftfl.icamera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnRegister;
	Button btnRetrive;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  btnRegister=(Button)findViewById(R.id.buttonRegister);
	  btnRetrive=(Button)findViewById(R.id.buttonRetrive);
	  //diet=(Button)findViewById(R.id.buttonDailyDietPlan);
	  
	  btnRegister.setOnClickListener(new OnClickListener() {
	   
	
	   public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Intent i=new Intent ( MainActivity.this,RegisterActivity.class);
	    startActivity(i);
	   }

	
	  });
	  
	  btnRetrive.setOnClickListener(new OnClickListener() {
	  
		  public void onClick(View v) {
			    // TODO Auto-generated method stub
			    Intent i=new Intent ( MainActivity.this,RetriveActivity.class);
			    startActivity(i);
			   }
			  });
	 }
}