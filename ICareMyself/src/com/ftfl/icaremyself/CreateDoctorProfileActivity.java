package com.ftfl.icaremyself;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.DoctorDataSource;
import com.ftfl.icaremyself.model.FTFLConstants;
import com.ftfl.icaremyself.util.DoctorProfile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateDoctorProfileActivity extends Activity {

	EditText etName = null, etSpecial = null, etPhn = null, etEmail = null, etAddress = null;
	String mName = "", mSpecial = "", mPhn = "", mEmail = "", mAddress = "";
	DoctorProfile mProfile = null;
	DoctorDataSource mSqlSource = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_doctor_profile);

		mSqlSource = new DoctorDataSource(this);

		etName = (EditText) findViewById(R.id.etDrName);
		etSpecial = (EditText) findViewById(R.id.createSpecialist);
		etPhn = (EditText) findViewById(R.id.createContact);
		etEmail = (EditText) findViewById(R.id.createEmail);
		etAddress = (EditText) findViewById(R.id.createAddress);
	}

	public void saveDoctor(View view) {

		mName = etName.getText().toString();
		mSpecial = etSpecial.getText().toString();
		mPhn = etPhn.getText().toString();
		mEmail = etEmail.getText().toString();
		mAddress = etAddress.getText().toString();

		mProfile = new DoctorProfile(mName, mSpecial, mPhn, mEmail, mAddress);

		long inserted = mSqlSource.insert(mProfile);

		if ((isValidEmail(mEmail)) && inserted >= 0) {
			Toast.makeText(getApplicationContext(), FTFLConstants.INSERT_DONE,
					Toast.LENGTH_LONG).show();
			Intent i = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(i);
			finish();
		} else
			Toast.makeText(getApplicationContext(), FTFLConstants.INSERT_PRBLM,
					Toast.LENGTH_LONG).show();

	}
	
	public final static boolean isValidEmail(CharSequence viewEmail) {
		if (TextUtils.isEmpty(viewEmail)) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(viewEmail)
					.matches();
		}
	}

}
