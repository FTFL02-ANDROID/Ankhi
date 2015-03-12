package com.ftfl.icaremyself.fragment;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.ProfileDataSource;
import com.ftfl.icaremyself.database.SQLiteHelper;
import com.ftfl.icaremyself.model.OnShakeListener;
import com.ftfl.icaremyself.model.ShakeDetector;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ViewProfileFragment extends Fragment {

	public static final String TAG = ViewProfileFragment.class.getSimpleName();

	TextView tvName, tvAge, tvWeight, tvHeight, tvPhn,tvDob,tvBloodGroup, tvSpComment;
	ProfileDataSource mSqlSource;
	String mPhoneNumner = "";

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;

	public static ViewProfileFragment newInstance() {
		return new ViewProfileFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_view_profile, container,
				false);

		mSqlSource = new ProfileDataSource(getActivity());
		
		tvName = (TextView) rootView.findViewById(R.id.viewName);
		tvAge = (TextView) rootView.findViewById(R.id.viewAge);
		tvWeight = (TextView) rootView.findViewById(R.id.viewWeight);
		tvHeight = (TextView) rootView.findViewById(R.id.viewHeight);
		tvDob = (TextView) rootView.findViewById(R.id.viewDOB);
		tvBloodGroup = (TextView) rootView.findViewById(R.id.viewBloodGroup);
		tvPhn = (TextView) rootView.findViewById(R.id.tvPhn);
		tvSpComment = (TextView) rootView.findViewById(R.id.viewSpComment);

		int value = 1;
		Cursor cursor = mSqlSource.getData(value);
		if (cursor.moveToFirst()) {

			String name = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_NAME));
			String age = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_AGE));
			String height = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_HEIGHT));
			String weight = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_WEIGHT));
			String spcoment = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_SPECIAL_NOTES));
			String dob = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH));
			String bloodgroup = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP));
			
			/*String phone = cursor.getString(cursor
					.getColumnIndex(SQLiteHelper.COLUMNL_PHONE_FIELD ));
*/
			//mPhoneNumner = phone;

			tvName.setText(name);
			tvAge.setText(age + " years");
			tvHeight.setText("Height " + height + " cm");
			tvWeight.setText("Weight " + weight + " K.G");
			tvSpComment.setText("Major Diseases: " + spcoment);
			tvDob.setText("Date Of Birth " + dob );
			tvBloodGroup.setText("Blood Group" + bloodgroup);
			//tvPhn.setText("Emergency :" + phone);

		}

		mSensorManager = (SensorManager) getActivity().getSystemService(
				Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mShakeDetector = new ShakeDetector(new OnShakeListener() {

			@Override
			public void onShake() {

				Intent callIntent = new Intent(Intent.ACTION_CALL,
						Uri.parse("tel:" + mPhoneNumner));
				startActivity(callIntent);
			}
		});

		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();
		mSensorManager.registerListener(mShakeDetector, mAccelerometer,
				SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	public void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(mShakeDetector);
	}

}


