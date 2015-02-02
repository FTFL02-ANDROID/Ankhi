package com.ftfl.healthcare.database;

import java.util.ArrayList;
import java.util.List;

import com.ftfl.healthcare.util.ProfileModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class HealthDBSource {

	// Database fields
		private SQLiteDatabase healthDatabase;	
		private HealthDBHelper healthDbHelper;
		List<ProfileModel> hospitalProfilesList = new ArrayList<ProfileModel>();
		
		public HealthDBSource(Context context) {
			healthDbHelper = new HealthDBHelper(context);
		}
		
		
		//open a method for writable database
		 
		public void open() throws SQLException {
			healthDatabase = healthDbHelper.getWritableDatabase();
		}
		
		//close database connection
		 
		public void close() {
			healthDbHelper.close();
		}
		
		/*
		 * insert data into the database.
		 */

		public boolean insert(ProfileModel profile) {

			this.open();

			ContentValues cv = new ContentValues();

			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_NAME, profile.getmHospitalName());

			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_ADDRESS, profile.getmHospitslAddress());
			
			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_DESCRIPTION, profile.getmHospitalDescription());
			
			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_LATITUDE, profile.getmLatitude());
			
			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_LONGTITUDE, profile.getmLongitude());
			
			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NAME, profile.getmAvailableDoctorName());
			
			cv.put(HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NUMBER, profile.getmAvailableDoctorNumber());


			Long check = healthDatabase.insert(HealthDBHelper.HEALTH_PROFILE, null, cv);
			healthDatabase.close();
		
			this.close();
			if(check <0)
				return false;
			else
				return true;
		}
		
		// Updating database by id
		public boolean updateData(long profileId, ProfileModel profile) {
			this.open();
			ContentValues cvUpdate = new ContentValues();

			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_NAME, profile.getmHospitalName());
			
			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_ADDRESS, profile.getmHospitslAddress());
			
			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_DESCRIPTION, profile.getmHospitalDescription());
			
			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_LATITUDE, profile.getmLatitude());
			
			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_LONGTITUDE, profile.getmLongitude());
			
			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NAME, profile.getmAvailableDoctorName());
			
			cvUpdate.put(HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NUMBER, profile.getmAvailableDoctorNumber());

			
			int check =  healthDatabase.update(HealthDBHelper.HEALTH_PROFILE, cvUpdate,
					HealthDBHelper.COL_HEALTH_PROFILE_ID + "=" + profileId, null);
			healthDatabase.close();
		
			this.close();
			
			if(check ==0)
				return false;
			else
				return true;
		}
		
		// delete data form database.
		public boolean deleteData(long profileId) {
			this.open();
			try {
				healthDatabase.delete(HealthDBHelper.HEALTH_PROFILE, HealthDBHelper.COL_HEALTH_PROFILE_ID 
						+ "=" + profileId,	null);
				
			} catch (Exception ex) {
				Log.e("ERROR", "data insertion problem");
				return false;
			}
			
			this.close();
			return true;
		}
		
		/*
		 * using cursor for display data from database.
		 */
		public List<ProfileModel> hospitalProfilesList() {
			this.open();

			Cursor mCursor = healthDatabase.query(HealthDBHelper.HEALTH_PROFILE,
					new String[] { HealthDBHelper.COL_HEALTH_PROFILE_ID,
								HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_NAME,
								HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_ADDRESS,
								HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_DESCRIPTION,
								HealthDBHelper.COL_HEALTH_PROFILE_LATITUDE,
								HealthDBHelper.COL_HEALTH_PROFILE_LONGTITUDE,
								HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NAME,
								HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NUMBER}, 
								null, null, null, null, null, null);

			if (mCursor != null) {
				if (mCursor.moveToFirst()) {

					do {

						String mId = mCursor.getString(mCursor.getColumnIndex("id"));
						
						String mHospitalName = mCursor.getString(mCursor.getColumnIndex("hospital_name"));
						
						String mHospitalAddress = mCursor.getString(mCursor.getColumnIndex("hospital_address"));
												
						String mLatitude = mCursor.getString(mCursor.getColumnIndex("latitude"));
						
						String mLongitude = mCursor.getString(mCursor.getColumnIndex("longitude"));
						
						String mHospitalDescription = mCursor.getString(mCursor.getColumnIndex("hospital_description"));
						
						String mAvailableDoctorName = mCursor.getString(mCursor.getColumnIndex("available_doctor_name"));
						
						String mAvailableDoctorNumber = mCursor.getString(mCursor.getColumnIndex("available_doctor_number"));
						
						// long mmId = Long.parseLong(mId);
						hospitalProfilesList.add(new ProfileModel(mId, mHospitalName, mHospitalAddress, mLatitude, 
								mLongitude, mHospitalDescription, mAvailableDoctorName, mAvailableDoctorNumber));

					} while (mCursor.moveToNext());
				}
				mCursor.close();
			}
			this.close();
			return hospitalProfilesList;
		}
		
		public boolean isEmpty(){
			this.open();
			Cursor mCursor = healthDatabase.query(HealthDBHelper.HEALTH_PROFILE,
					new String[] { HealthDBHelper.COL_HEALTH_PROFILE_ID,
								HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_NAME,
								HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_ADDRESS,
								HealthDBHelper.COL_HEALTH_PROFILE_HOSPITAL_DESCRIPTION,
								HealthDBHelper.COL_HEALTH_PROFILE_LATITUDE,
								HealthDBHelper.COL_HEALTH_PROFILE_LONGTITUDE,
								HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NAME,
								HealthDBHelper.COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NUMBER}, 
								null, null, null, null, null, null);
			
	        if(mCursor.getCount() == 0) {
	        	this.close();
	        	return true;
	        }
	        
	        else
	        {
	        	this.close();
	        	return false;
	        }
	    }


		public Cursor getData(int value) {
			// TODO Auto-generated method stub
			return null;
		}
	}


