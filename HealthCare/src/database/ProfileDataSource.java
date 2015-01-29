package database;

import java.util.ArrayList;
import java.util.List;

import util.Profile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ProfileDataSource {
	// Database fields
		private SQLiteDatabase healthCareDatabase;
		private SQLLiteHelper healthCareDbHelper;
		List<Profile> healthCareProfilesList = new ArrayList<Profile>();

		public ProfileDataSource(Context context) {
			healthCareDbHelper = new SQLLiteHelper();
		}

		/*
		 * open a method for writable database
		 */
		public void open() throws SQLException {
			healthCareDatabase = SQLLiteHelper.getWritableDatabase();
		}

		/*
		 * close database connection
		 */
		public void close() {
			healthCareDbHelper.close();
		}

		/*
		 * insert data into the database.
		 */

		public boolean insert(Profile iprofile) {

			this.open();

			ContentValues cv = new ContentValues();

			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_NAME, iprofile.getName());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_FNAME, iprofile.getFname());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_MNAME, iprofile.getMname());

			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_AGE, iprofile.getAge());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
					iprofile.getBlooGroup());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_EYE_COLOR, iprofile.getEyeColor());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_WEIGHT, iprofile.getWeight());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_HEIGHT, iprofile.getHeight());
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
					iprofile.getDateOfBirth());
		
			cv.put(SQLLiteHelper.COL_ICARE_PROFILE_SPECIFIC_PROBLEM,
					iprofile.getSpecialNotes());


			Long check = healthCareDatabase.insert(SQLLiteHelper.Health_CARE_PROFILE, null, cv);
			healthCareDatabase.close();
		
			this.close();
			if(check <0)
				return false;
			else
				return true;
		}

		// Updating database by id
		public boolean updateData(long profileId, Profile iprofile) {
			this.open();
			ContentValues cvUpdate = new ContentValues();

			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_NAME,
					iprofile.getName());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_FNAME,
					iprofile.getFname());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_MNAME,
					iprofile.getMname());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_AGE, iprofile.getAge());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
					iprofile.getBlooGroup());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_EYE_COLOR,
					iprofile.getEyeColor());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_WEIGHT,
					iprofile.getWeight());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_HEIGHT,
					iprofile.getHeight());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
					iprofile.getDateOfBirth());
			cvUpdate.put(SQLLiteHelper.COL_ICARE_PROFILE_SPECIFIC_PROBLEM,
					iprofile.getSpecialNotes());

			
			int check =  healthCareDatabase.update(SQLLiteHelper.Health_CARE_PROFILE, cvUpdate,
					SQLLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileId,
						null);
			healthCareDatabase.close();
		
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
				healthCareDatabase.delete(SQLLiteHelper.Health_CARE_PROFILE,
						SQLLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileId,
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
		public List<Profile> iCareProfilesList() {
			this.open();

			Cursor mCursor = healthCareDatabase.query(SQLLiteHelper.Health_CARE_PROFILE,
					new String[] { SQLLiteHelper.COL_ICARE_PROFILE_ID,
					SQLLiteHelper.COL_ICARE_PROFILE_NAME,
					SQLLiteHelper.COL_ICARE_PROFILE_AGE,
					SQLLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
					SQLLiteHelper.COL_ICARE_PROFILE_WEIGHT,
							SQLLiteHelper.COL_ICARE_PROFILE_HEIGHT,
							SQLLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
							SQLLiteHelper.COL_ICARE_PROFILE_SPECIFIC_PROBLEM}, null,
					null, null, null, null);

			if (mCursor != null) {
				if (mCursor.moveToFirst()) {

					do {

						String mId = mCursor
								.getString(mCursor.getColumnIndex("id"));
						String mName = mCursor.getString(mCursor
								.getColumnIndex("name"));
						String mFname = mCursor.getString(mCursor
								.getColumnIndex("fname"));
						String mMname = mCursor.getString(mCursor
								.getColumnIndex("nname"));
						String mAge = mCursor.getString(mCursor
								.getColumnIndex("age"));
						String mBloodGroup = mCursor.getString(mCursor
								.getColumnIndex("blood_group"));
						String mEyeColor = mCursor.getString(mCursor
								.getColumnIndex("eyeColor"));
						String mWeight = mCursor.getString(mCursor
								.getColumnIndex("weight"));
						String mHeight = mCursor.getString(mCursor
								.getColumnIndex("height"));
						String mDateOfBirth = mCursor.getString(mCursor
								.getColumnIndex("dateofbirth"));
						String mSpecialNotes = mCursor.getString(mCursor
								.getColumnIndex("specific_problem"));
						// long mmId = Long.parseLong(mId);
						healthCareProfilesList.add(new Profile(mId, mName,mFname,mMname,
								mAge, mBloodGroup,mEyeColor,mWeight, mHeight, mDateOfBirth,
								mSpecialNotes));

					} while (mCursor.moveToNext());
				}
				mCursor.close();
			}
			this.close();
			return healthCareProfilesList;
		}

		/*
		 * create a profile of ICareProfile. Here the data of the database according
		 * to the given id is set to the profile and return a profile.
		 */
		public Profile singleProfileData( ) {
			this.open();
			Profile iCareUpdateProfile;
			String mId;
			String mName;
			String mFname;
			String mMname;
			int profileID = 1;
			String mAge;
			String mBloodGroup;
			String mEyeColor;
			String mWeight;
			String mHeight;
			String mDateOfBirth;
		
			String mSpecialNotes;
		

			Cursor mUpdateCursor = healthCareDatabase.query(
					SQLLiteHelper.Health_CARE_PROFILE, new String[] {
							SQLLiteHelper.COL_ICARE_PROFILE_ID,
							SQLLiteHelper.COL_ICARE_PROFILE_NAME,
							SQLLiteHelper.COL_ICARE_PROFILE_FNAME,
							SQLLiteHelper.COL_ICARE_PROFILE_MNAME,
							SQLLiteHelper.COL_ICARE_PROFILE_AGE,
							SQLLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
							SQLLiteHelper.COL_ICARE_PROFILE_EYE_COLOR,
							SQLLiteHelper.COL_ICARE_PROFILE_WEIGHT,
							SQLLiteHelper.COL_ICARE_PROFILE_HEIGHT,
							SQLLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
							SQLLiteHelper.COL_ICARE_PROFILE_SPECIFIC_PROBLEM, },
							SQLLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileID, null,
					null, null, null);

			mUpdateCursor.moveToFirst();

			mId = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("id"));
			mName = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("name"));
			mFname = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("fname"));
			mMname = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("mname"));
			mEyeColor = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("eyecolor"));
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
			mUpdateCursor.close();
			iCareUpdateProfile = new Profile(mId,mName, mFname,mMname,
					mAge, mBloodGroup,mEyeColor,mWeight, mHeight, mDateOfBirth,
					mSpecialNotes);
			this.close();
			return iCareUpdateProfile;
		}
		
		public boolean isEmpty(){
			this.open();
			Cursor mCursor = healthCareDatabase.query(SQLLiteHelper.Health_CARE_PROFILE,
					new String[] { SQLLiteHelper.COL_ICARE_PROFILE_ID,
					SQLLiteHelper.COL_ICARE_PROFILE_NAME,
					SQLLiteHelper.COL_ICARE_PROFILE_FNAME,
					SQLLiteHelper.COL_ICARE_PROFILE_MNAME,
					SQLLiteHelper.COL_ICARE_PROFILE_AGE,
					SQLLiteHelper.COL_ICARE_PROFILE_BLOOD_GROUP,
					SQLLiteHelper.COL_ICARE_PROFILE_EYE_COLOR,
					SQLLiteHelper.COL_ICARE_PROFILE_WEIGHT,
					SQLLiteHelper.COL_ICARE_PROFILE_HEIGHT,
					SQLLiteHelper.COL_ICARE_PROFILE_DATE_OF_BIRTH,
					SQLLiteHelper.COL_ICARE_PROFILE_SPECIFIC_PROBLEM}, null,
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


