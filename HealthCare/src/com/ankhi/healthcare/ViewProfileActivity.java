package com.ankhi.healthcare;

import com.google.android.gms.internal.mf;

import util.Profile;
import database.ProfileDataSource;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewProfileActivity extends Activity {

	Button update_btn = null;
	EditText et_name = null;
	EditText et_fname = null;
	EditText et_mname = null;
	EditText et_age = null;
	EditText etBloodGroup = null;
	EditText et_EyeColor = null;
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
	String mSpecificProblem = "";
	
	Profile mUpdateProfile = null;
	ProfileDataSource mDataSource = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_profile);
		
		// set the textfield id to the variable.
		et_name = (EditText) findViewById(R.id.viewName);
		et_fname = (EditText) findViewById(R.id.viewfName);
		et_mname = (EditText) findViewById(R.id.viewMname);
		et_age = (EditText) findViewById(R.id.viewAge);
		etBloodGroup = (EditText) findViewById(R.id.viewBloodGroup);
		et_EyeColor = (EditText) findViewById(R.id.viewEyeColor);
		et_weight = (EditText) findViewById(R.id.viewWeight);
		et_height = (EditText) findViewById(R.id.viewHeight);
		et_dateOfBirth = (EditText) findViewById(R.id.viewDOB);
		et_specificProblem = (EditText) findViewById(R.id.viewSpComment);
		update_btn = (Button) findViewById(R.id.update);
		
		/*
		 * get the profile which include all data from database according
		 * profileId of the clicked item.
		 */
		mDataSource = new ProfileDataSource(this);
		mUpdateProfile = mDataSource.singleProfileData();

		String mName = mUpdateProfile.getName();
		String mFname = mUpdateProfile.getFname();
		String mMname = mUpdateProfile.getMname();
		String mAge = mUpdateProfile.getAge();
		String mEyeColor = mUpdateProfile.getEyeColor();
		String mBloodGroup = mUpdateProfile.getBlooGroup();
		String mWeight = mUpdateProfile.getWeight();
		String mHeight = mUpdateProfile.getHeight();
		String mDateOfBirth = mUpdateProfile.getDateOfBirth();
		String mSpecificProblem = mUpdateProfile.getSpecialNotes();


		// set the value of database to the text field.
		et_name.setText(mName);
		et_fname.setText(mFname);
		et_mname.setText(mMname);
		et_age.setText(mAge);
		etBloodGroup.setText(mBloodGroup);
		et_EyeColor.setText(mEyeColor);
		et_weight.setText(mWeight);
		et_height.setText(mHeight);
		et_dateOfBirth.setText(mDateOfBirth);
		et_specificProblem.setText(mSpecificProblem);
	
	}
	
	
	public void updateProfile(View v) {

		switch (v.getId()) {

		case R.id.update:
			
			mName = et_name.getText().toString();
			mFname = et_fname.getText().toString();
			mMname = et_mname.getText().toString();
			mAge = et_age.getText().toString();
			mBloodGroup = etBloodGroup.getText().toString();
			mEyeColor = et_EyeColor.getText().toString();
			mWeight = et_weight.getText().toString();
			mHeight = et_height.getText().toString();
			mDateOfBirth = et_dateOfBirth.getText().toString();
			mSpecificProblem = et_specificProblem.getText().toString();
			
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
						profileDataInsert.setSpecificProblem(mSpecificProblem);
						
						
						mDataSource = new ProfileDataSource(this);

						if (mDataSource.updateData(1, profileDataInsert) == true) {
							toast = Toast.makeText(this, "Successfully Updated.",
									Toast.LENGTH_LONG);
							toast.show();

							Intent intent = new Intent(ViewProfileActivity.this,
									MapActivity.class);
							
					
							//finish();

							// startActivity(new Intent(ICareNewProfileActivity.this,
							// ICareProfilePreviewActivity.class));
							// finish();
						} else {
							toast = Toast.makeText(this, "Not Updated.",
									Toast.LENGTH_LONG);
							toast.show();
						}
						
						break;
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_profile, menu);
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
}

