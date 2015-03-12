package com.ftfl.icaremyself.database;

import java.util.ArrayList;
import java.util.List;

import com.ftfl.icaremyself.util.ProfileInfo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ProfileDataSource {

	// Database fields
	private SQLiteDatabase iCareDatabase;
	private SQLiteHelper iCareDbHelper;
	List<ProfileInfo> iCareProfilesList = new ArrayList<ProfileInfo>();

	public ProfileDataSource(Context context) {
		iCareDbHelper = new SQLiteHelper(context);
	}

	/*
	 * open a method for writable database
	 */
	public void open() throws SQLException {
		iCareDatabase = iCareDbHelper.getWritableDatabase();
	}

	/*
	 * close database connection
	 */
	public void close() {
		iCareDbHelper.close();
	}

	/*
	 * insert data into the database.
	 */

	public boolean insert(ProfileInfo iprofile) {

		this.open();

		ContentValues cv = new ContentValues();

		cv.put(SQLiteHelper.COL_ICARE_PROFILE_NAME, iprofile.getName());

		cv.put(SQLiteHelper.COL_ICARE_PROFILE_AGE, iprofile.getAge());
		cv.put(SQLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
				iprofile.getBlooGroup());
		cv.put(SQLiteHelper.COL_ICARE_PROFILE_WEIGHT, iprofile.getWeight());
		cv.put(SQLiteHelper.COL_ICARE_PROFILE_HEIGHT, iprofile.getHeight());

		cv.put(SQLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
				iprofile.getDateOfBirth());
	
		cv.put(SQLiteHelper.COL_ICARE_PROFILE_SPECIAL_NOTES,
				iprofile.getSpecialNotes());


		Long check = iCareDatabase.insert(SQLiteHelper.I_CARE_PROFILE, null, cv);
			iCareDatabase.close();
	
		this.close();
		if(check <0)
			return false;
		else
			return true;
	}

	// Updating database by id
	public boolean updateData(long profileId, ProfileInfo iprofile) {
		this.open();
		ContentValues cvUpdate = new ContentValues();

		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_NAME,
				iprofile.getName());
		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_AGE, iprofile.getAge());
		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
				iprofile.getBlooGroup());
		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_WEIGHT,
				iprofile.getWeight());
		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_HEIGHT,
				iprofile.getHeight());
		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
				iprofile.getDateOfBirth());
		cvUpdate.put(SQLiteHelper.COL_ICARE_PROFILE_SPECIAL_NOTES,
				iprofile.getSpecialNotes());


		
		int check =  iCareDatabase.update(SQLiteHelper.I_CARE_PROFILE, cvUpdate,
					SQLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileId,
					null);
			iCareDatabase.close();
	
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
			iCareDatabase.delete(SQLiteHelper.I_CARE_PROFILE,
					SQLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileId,
					null);
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
	public List<ProfileInfo> iCareProfilesList() {
		this.open();

		Cursor mCursor = iCareDatabase.query(SQLiteHelper.I_CARE_PROFILE,
				new String[] { SQLiteHelper.COL_ICARE_PROFILE_ID,
						SQLiteHelper.COL_ICARE_PROFILE_NAME,
						SQLiteHelper.COL_ICARE_PROFILE_AGE,
						SQLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
						SQLiteHelper.COL_ICARE_PROFILE_WEIGHT,
						SQLiteHelper.COL_ICARE_PROFILE_HEIGHT,
						SQLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
						SQLiteHelper.COL_ICARE_PROFILE_SPECIAL_NOTES}, null,
				null, null, null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String mId = mCursor
							.getString(mCursor.getColumnIndex("id"));
					String mName = mCursor.getString(mCursor
							.getColumnIndex("name"));
					String mAge = mCursor.getString(mCursor
							.getColumnIndex("age"));
					String mBloodGroup = mCursor.getString(mCursor
							.getColumnIndex("blood_group"));
					String mWeight = mCursor.getString(mCursor
							.getColumnIndex("weight"));
					String mHeight = mCursor.getString(mCursor
							.getColumnIndex("height"));
					String mDateOfBirth = mCursor.getString(mCursor
							.getColumnIndex("dateofbirth"));
					
					String mPhone = mCursor.getString(mCursor
							.getColumnIndex("phone"));
					String mSpecialNotes = mCursor.getString(mCursor
							.getColumnIndex("special_notes"));
					// long mmId = Long.parseLong(mId);

					iCareProfilesList.add(new ProfileInfo(mId, mName,mAge, mBloodGroup,
					mWeight, mHeight, mDateOfBirth,
					mSpecialNotes,mPhone));


				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return iCareProfilesList;
	}

	/*
	 * create a profile of ICareProfile. Here the data of the database according
	 * to the given id is set to the profile and return a profile.
	 */
	public ProfileInfo singleProfileData( ) {
		this.open();
		ProfileInfo iCareUpdateProfile;
		String mId;
		String mName;
		int profileID = 1;
		String mAge;
		String mBloodGroup;
		String mWeight;
		String mHeight;
		String mDateOfBirth;
		String mPhone;
	
		String mSpecialNotes;
	

		Cursor mUpdateCursor = iCareDatabase.query(
				SQLiteHelper.I_CARE_PROFILE, new String[] {
						SQLiteHelper.COL_ICARE_PROFILE_ID,
						SQLiteHelper.COL_ICARE_PROFILE_NAME,
						SQLiteHelper.COL_ICARE_PROFILE_AGE,
						SQLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
						SQLiteHelper.COL_ICARE_PROFILE_WEIGHT,
						SQLiteHelper.COL_ICARE_PROFILE_HEIGHT,
						SQLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
						SQLiteHelper.COL_ICARE_PROFILE_SPECIAL_NOTES },
						SQLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileID, null,
				null, null, null);

		mUpdateCursor.moveToFirst();

		mId = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("id"));
		mName = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("name"));
		mAge = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("age"));
		mBloodGroup = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("blood_group"));
		mWeight = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("weight"));
		mHeight = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("height"));
		mDateOfBirth = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("dateofbirth"));
		mSpecialNotes = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("special_notes"));
		mPhone = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("phone"));
		mUpdateCursor.close();
		iCareUpdateProfile = new ProfileInfo(mId, mName, mAge, mBloodGroup, mWeight, mHeight, mDateOfBirth,
				 mSpecialNotes,mPhone);
		this.close();
		return iCareUpdateProfile;
	}

	
	public Cursor getData(int id) {
		this.open();
		Cursor cursor = iCareDatabase.rawQuery(
				"select * from icareprofiles where _id=" + id + "", null);
		return cursor;
	}
	public boolean isEmpty(){
		this.open();
		Cursor mCursor = iCareDatabase.query(SQLiteHelper.I_CARE_PROFILE,
				new String[] { SQLiteHelper.COL_ICARE_PROFILE_ID,
						SQLiteHelper.COL_ICARE_PROFILE_NAME,
						SQLiteHelper.COL_ICARE_PROFILE_AGE,
						SQLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
						SQLiteHelper.COL_ICARE_PROFILE_WEIGHT,
						SQLiteHelper.COL_ICARE_PROFILE_HEIGHT,
						SQLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
						SQLiteHelper.COL_ICARE_PROFILE_SPECIAL_NOTES}, null,
				null, null, null, null);
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

}
