package com.ftfl.healthcare.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HealthDBHelper extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "health.db";
	private static final int DATABASE_VERSION = 1;
	
    // HOSPITAL Profile Table
	public static final String HEALTH_PROFILE = "hospitalprofiles";
	public static final String COL_HEALTH_PROFILE_ID = "id";
	public static final String COL_HEALTH_PROFILE_HOSPITAL_NAME = "hospital_name";
	public static final String COL_HEALTH_PROFILE_HOSPITAL_ADDRESS = "hospital_address";
	public static final String COL_HEALTH_PROFILE_LATITUDE = "latitude";
	public static final String COL_HEALTH_PROFILE_LONGTITUDE = "longitude";
	public static final String COL_HEALTH_PROFILE_HOSPITAL_DESCRIPTION = "hospital_description";
	public static final String COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NAME = "availabele_doctor_name";
	public static final String COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NUMBER = "availabele_doctor_number";
	
	// Database creation sql statement
	private static final String DATABASE_CREATE_PROFILE = "create table "
			+ HEALTH_PROFILE + "( " + COL_HEALTH_PROFILE_ID
			+ " integer primary key autoincrement, " + " "
			+ COL_HEALTH_PROFILE_HOSPITAL_NAME + " text not null," + " "
			+ COL_HEALTH_PROFILE_HOSPITAL_ADDRESS + " text not null," + " "
			+ COL_HEALTH_PROFILE_LATITUDE + " text not null," + " "
			+ COL_HEALTH_PROFILE_LONGTITUDE + " text not null," + " "
			+ COL_HEALTH_PROFILE_HOSPITAL_DESCRIPTION + " text not null," + " "
			+ COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NAME + " text not null," + " "
			+ COL_HEALTH_PROFILE_AVAILABLE_DOCTOR_NUMBER + " text not null);";
	
	public HealthDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_PROFILE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(HealthDBHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
		
		database.execSQL("DROP TABLE IF EXISTS " + HEALTH_PROFILE);		
		onCreate(database);
		
	}

	}
