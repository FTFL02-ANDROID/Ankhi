package com.ankhi.healthcare;

import util.Profile;
import database.ProfileDataSource;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateProfileActivity extends Activity implements OnClickListener{
	Button save_btn = null;
	EditText et_name = null;
	EditText et_fname = null;
	EditText et_mname = null;
	EditText et_age = null;
	EditText etBloodGroup = null;
	EditText et_eyecolor = null;
	EditText et_weight = null;
	EditText et_height = null;
	EditText et_dateOfBirth = null;
	EditText et_specificProblem = null;
	Toast toast = null;
	
	String mName = "";
	String mFname = "";
	String mMname = "";
	String mAge = "";
	String mBloodGroup = "";
	String mEyeColor = "";
	String mWeight = "";
	String mHeight = "";
	String mDateOfBirth = "";
	String mSpecialProblem = "";
	
	

	ProfileDataSource icareDS = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);
        
        

		// set the text field id to the variable.
		et_name = (EditText) findViewById(R.id.createUserName);
		et_fname = (EditText) findViewById(R.id.createFname);
		et_mname = (EditText) findViewById(R.id.createMname);
		et_age = (EditText) findViewById(R.id.createAge);
		etBloodGroup = (EditText) findViewById(R.id.createBloodGroup);
		et_eyecolor = (EditText) findViewById(R.id.createEyeColor);
		et_weight = (EditText) findViewById(R.id.createWeight);
		et_height = (EditText) findViewById(R.id.createHeight);
		et_dateOfBirth = (EditText) findViewById(R.id.createDateOfBirth);
		et_specificProblem = (EditText) findViewById(R.id.createSpecialComment);
		save_btn = (Button) findViewById(R.id.Save);
		save_btn.setOnClickListener(this);
        
    }
    
    



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_profile, menu);
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


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {

		case R.id.Save:
			mName = et_name.getText().toString();
			mFname =et_fname.getText().toString();
			mMname =et_mname.getText().toString();
			mAge = et_age.getText().toString();
			mBloodGroup = etBloodGroup.getText().toString();
			mEyeColor =et_eyecolor.getText().toString();
			mWeight = et_weight.getText().toString();
			mHeight = et_height.getText().toString();
			mDateOfBirth = et_dateOfBirth.getText().toString();
			mSpecialProblem = et_specificProblem.getText().toString();
			
			// Assign values in the ICareProfile
						Profile profileDataInsert = new Profile();
						profileDataInsert.setName(mName);
						profileDataInsert.setFname(mFname);
						profileDataInsert.setMname(mMname);
						profileDataInsert.setAge(mAge);
						profileDataInsert.setBloodGroup(mBloodGroup);
						profileDataInsert.setEyeColor(mEyeColor);
						profileDataInsert.setWeight(mWeight);
						profileDataInsert.setHeight(mHeight);
						profileDataInsert.setDateOfBirth(mDateOfBirth);
						profileDataInsert.setSpecificProblem(mSpecialProblem);
						/*
						 * if update is needed then update otherwise submit
						 */
			
							icareDS = new ProfileDataSource(this);
							if (icareDS.insert(profileDataInsert) == true) {
								toast = Toast.makeText(this, "Successfully Submitted.",
										Toast.LENGTH_LONG);
								toast.show();
								startActivity(new Intent(CreateProfileActivity.this,
										ViewProfileActivity.class));
							} else {
								toast = Toast.makeText(this, "Not Submitted.",
										Toast.LENGTH_LONG);
								toast.show();
							}

						break;
		}
		
	}





}
