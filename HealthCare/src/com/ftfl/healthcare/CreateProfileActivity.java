package com.ftfl.healthcare;

import com.ftfl.healthcare.database.HealthDBSource;
import com.ftfl.healthcare.util.ProfileModel;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateProfileActivity extends Activity {
	
	Button btnSave = null;
	
	EditText etHospitalName = null;
	EditText etHospitalAddress = null;
	EditText etLatitude = null;
	EditText etLongitude = null;
	EditText etHospitalDescription = null;
	EditText etAvailableDoctorName = null;
	EditText etAvailableDoctorNumber = null;
	
	Toast toast = null;
	
	String mHospitalName = "";
	String mHospitalAddress = "";
	String mLatitude = "";
	String mLongitude = "";
	String mHospitalDescription = "";
	String mAvailableDoctorName = "";
	String mAvailableDoctorNumber = "";
	
	HealthDBSource healthDBSource = new HealthDBSource(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_profile);
		
		// set the text field id to the variable.
		etHospitalName = (EditText) findViewById(R.id.createHospitalName);
		etHospitalAddress = (EditText) findViewById(R.id.createHospitalAddress);
		etLatitude = (EditText) findViewById(R.id.createLatitude);
		etLongitude = (EditText) findViewById(R.id.createLongitude);
		etHospitalDescription = (EditText) findViewById(R.id.createHospitalDescription);
		etAvailableDoctorName = (EditText) findViewById(R.id.createAvailableDoctorName);
		etAvailableDoctorNumber = (EditText) findViewById(R.id.createAvailableDoctoNumber);
		
		btnSave = (Button) findViewById(R.id.Save);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mHospitalName = etHospitalName.getText().toString();
				mHospitalAddress = etHospitalAddress.getText().toString();
				mLatitude = etLatitude.getText().toString();
				mLongitude = etLongitude.getText().toString();
				mHospitalDescription = etHospitalDescription.getText().toString();
				mAvailableDoctorName = etAvailableDoctorName.getText().toString();
				mAvailableDoctorNumber = etAvailableDoctorNumber.getText().toString();
				
				// Assign values in the Profile
				ProfileModel profileDataInsert = new ProfileModel();
				
				profileDataInsert.setmHospitalName(mHospitalName);
				profileDataInsert.setmHospitslAddress(mHospitalAddress);
				profileDataInsert.setmLatitude(mLatitude);
				profileDataInsert.setmLongitude(mLongitude);
				profileDataInsert.setmHospitalDescription(mHospitalDescription);
				profileDataInsert.setmAvailableDoctorName(mAvailableDoctorName);
				profileDataInsert.setmAvailableDoctorNumber(mAvailableDoctorNumber);
							
			    //if update is needed then update otherwise submit
				
				if (healthDBSource.insert(profileDataInsert) == true) {
					
					toast = Toast.makeText(CreateProfileActivity.this, "Successfully Saved.", Toast.LENGTH_LONG);
					toast.show();
					
					startActivity(new Intent(CreateProfileActivity.this, ViewProfileActivity.class));
					
				} else {
					
					toast = Toast.makeText(CreateProfileActivity.this, "Not Saved.", Toast.LENGTH_LONG);
					toast.show();
				}
				
			}			
		});
	}

}
