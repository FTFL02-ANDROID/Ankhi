package com.ftfl.icaremyself.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "ICareF.db";
	private static final int DATABASE_VERSION = 1;

	// ICare Profile Table
		public static final String I_CARE_PROFILE = "icareprofiles";
		public static final String COL_ICARE_PROFILE_ID = "_id";
		public static final String COL_ICARE_PROFILE_NAME = "name";
		public static final String COL_ICARE_PROFILE_AGE = "age";
		public static final String COL_ICARE_PROFILE_BLOOD_GROUP = "blood_group";
		public static final String COL_ICARE_PROFILE_WEIGHT = "weight";
		public static final String COL_ICARE_PROFILE_HEIGHT = "height";
		public static final String COL_ICARE_PROFILE_DATE_OF_BIRTH = "dateofbirth";
		public static final String COL_ICARE_PROFILE_SPECIAL_NOTES = "special_notes";
		public static final String COLUMNL_PHONE_FIELD = "phone";


	/** DIET TABLE */
	public static final String TABLE_NAME_DIET = "diet_chart";
	public static final String COLUMNL_ID_DT_FIELD = "_id";
	public static final String COLUMNL_NAME_DT_FIELD = "name_dt";
	public static final String COLUMNL_DATE_FIELD = "date";
	public static final String COLUMNL_TIME_FIELD = "time";
	public static final String COLUMNL_MENU_FIELD = "menu";
	public static final String COLUMNL_ALARM_FIELD = "alarm";

	/** DOCTOR TABLE */
	public static final String TABLE_NAME_DOCTOR = "doctor";
	public static final String COLUMNL_ID_DR_FIELD = "_id";
	public static final String COLUMNL_NAME_DR_FIELD = "name_dr";
	public static final String COLUMNL_SPECIAL_FIELD = "speciality";
	public static final String COLUMNL_PHONE_DR_FIELD = "phone_dr";
	public static final String COLUMNL_EMAIL_FIELD = "email";
	public static final String COLUMNL_ADDRESS_FIELD = "address";


	/** MEDICAL HISTORY TABLE */
	public static final String TABLE_NAME_MH = "medical_history";
	public static final String COLUMNL_ID_MH_FIELD = "_id";
	public static final String COLUMNL_NAME_MH_FIELD = "name_mh";
	public static final String COLUMNL_PURPOSE_FIELD = "purpose";
	public static final String COLUMNL_DATE_MH_FIELD = "date";
	public static final String COLUMNL_TIME_MH_FIELD = "time";
	public static final String COLUMNL_PHOTO_FIELD = "photo_path";

	/** VACCINE TABLE */
	public static final String TABLE_NAME_VACCINE = "vaccine";
	public static final String COLUMNL_ID_VC_FIELD = "_id";
	public static final String COLUMNL_NAME_VC_FIELD = "name_vc";
	public static final String COLUMNL_REASON_FIELD = "REASON";
	public static final String COLUMNL_DATE_VC_FIELD = "date_vc";
	public static final String COLUMNL_TIME_VC_FIELD = "time_vc";

	/** NOTE TABLE */
	public static final String TABLE_NAME_NOTE = "note_list";
	public static final String COLUMNL_ID_NT_FIELD = "_id";
	public static final String COLUMNL_NOTE_FIELD = "note";
	public static final String COLUMNL_DATE_NT_FIELD = "date_nt";

	/** HEALTH CENTER TABLE */
	public static final String TABLE_NAME_HC = "health_center";
	public static final String COLUMNL_ID_HC_FIELD = "_id";
	public static final String COLUMNL_NAME_HC_FIELD = "name_dt";
	public static final String COLUMNL_ICARE_ADDRESS_FIELD = "address";
	public static final String COLUMNL_PHONE_HC_FIELD = "phone";
	public static final String COLUMNL_LAT_FIELD = "latitude";
	public static final String COLUMNL_LANG_FIELD = "longitude";
	
	

	/** PROFILE SQL */
	public static final String TABLE_CRATE_SQL_PROFILE = "create table "
			+ I_CARE_PROFILE + "(" + COL_ICARE_PROFILE_ID + " INTEGER PRIMARY KEY, "
			+ COL_ICARE_PROFILE_NAME + " text, " + COL_ICARE_PROFILE_AGE + " text, "
			+ COL_ICARE_PROFILE_HEIGHT + " text, " + COL_ICARE_PROFILE_WEIGHT
			+ " text, " + COL_ICARE_PROFILE_BLOOD_GROUP + " text, "
			+ COL_ICARE_PROFILE_DATE_OF_BIRTH + " text, "
			+ COL_ICARE_PROFILE_SPECIAL_NOTES + " text, "
			+ COLUMNL_PHONE_FIELD + " text )";

	/** DIET SQL */
	public static final String TABLE_CRATE_SQL_DIET = "create table "
			+ TABLE_NAME_DIET + "(" + COLUMNL_ID_DT_FIELD
			+ " INTEGER PRIMARY KEY, " + COLUMNL_NAME_DT_FIELD + " text, "
			+ COLUMNL_DATE_FIELD + " text, " + COLUMNL_TIME_FIELD + " text, "
			+ COLUMNL_MENU_FIELD + " text, " + COLUMNL_ALARM_FIELD + " text)";

	/** DOCTOR SQL */
	public static final String TABLE_CRATE_SQL_DOCTOR = "create table "
			+ TABLE_NAME_DOCTOR + "(" + COLUMNL_ID_DR_FIELD
			+ " INTEGER PRIMARY KEY, " + COLUMNL_NAME_DR_FIELD + " text, "
			+ COLUMNL_SPECIAL_FIELD + " text, " + COLUMNL_PHONE_DR_FIELD
			+ " text, " + COLUMNL_EMAIL_FIELD + " text, "+ COLUMNL_ADDRESS_FIELD + " text)";

	/** MEDICAL HISTORY SQL */
	public static final String TABLE_CRATE_SQL_MH = "create table "
			+ TABLE_NAME_MH + "(" + COLUMNL_ID_MH_FIELD
			+ " INTEGER PRIMARY KEY, " + COLUMNL_NAME_MH_FIELD + " text, "
			+ COLUMNL_PURPOSE_FIELD + " text, " + COLUMNL_DATE_MH_FIELD
			+ " text, " + COLUMNL_TIME_MH_FIELD + " text, "
			+ COLUMNL_PHOTO_FIELD + " text)";

	/** VACCINE SQL */
	public static final String TABLE_CRATE_SQL_VACCINE = "create table "
			+ TABLE_NAME_VACCINE + "(" + COLUMNL_ID_VC_FIELD
			+ " INTEGER PRIMARY KEY, " + COLUMNL_NAME_VC_FIELD + " text, "
			+ COLUMNL_REASON_FIELD + " text, " + COLUMNL_DATE_VC_FIELD
			+ " text, " + COLUMNL_TIME_VC_FIELD + " text)";

	/** NOTE SQL */
	public static final String TABLE_CRATE_SQL_NOTE = "create table "
			+ TABLE_NAME_NOTE + "(" + COLUMNL_ID_NT_FIELD
			+ " INTEGER PRIMARY KEY, " + COLUMNL_NOTE_FIELD + " text, "
			+ COLUMNL_DATE_NT_FIELD + " text)";

	/** HEALTH CENTER SQL */
	public static final String TABLE_CRATE_SQL_HC = "create table "
			+ TABLE_NAME_HC + "(" + COLUMNL_ID_HC_FIELD
			+ " INTEGER PRIMARY KEY, " + COLUMNL_NAME_HC_FIELD + " text, "
			+ COLUMNL_ADDRESS_FIELD + " text, " + COLUMNL_PHONE_HC_FIELD
			+ " text, " + COLUMNL_LAT_FIELD + " text, " + COLUMNL_LANG_FIELD
			+ " text)";

	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(TABLE_CRATE_SQL_PROFILE);
		db.execSQL(TABLE_CRATE_SQL_DIET);
		db.execSQL(TABLE_CRATE_SQL_DOCTOR);
		db.execSQL(TABLE_CRATE_SQL_MH);
		db.execSQL(TABLE_CRATE_SQL_VACCINE);
		db.execSQL(TABLE_CRATE_SQL_NOTE);
		db.execSQL(TABLE_CRATE_SQL_HC);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		Log.w(SQLiteHelper.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");

		db.execSQL("DROP TABLE IF EXISTS " + I_CARE_PROFILE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DIET);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DOCTOR);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MH);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_VACCINE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_NOTE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_HC);
		
		onCreate(db);

	}
}
