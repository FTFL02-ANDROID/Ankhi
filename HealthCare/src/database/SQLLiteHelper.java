package database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLLiteHelper {
	// HealthCare Profile Table
		public static final String Health_CARE_PROFILE = "healthcareprofiles";
		public static final String COL_ICARE_PROFILE_ID = "id";
		public static final String COL_ICARE_PROFILE_NAME = "name";
		public static final String COL_ICARE_PROFILE_FNAME = "fname";
		public static final String COL_ICARE_PROFILE_MNAME = "mname";
		public static final String COL_ICARE_PROFILE_AGE = "age";
		public static final String COL_ICARE_PROFILE_BLOOD_GROUP = "blood_group";
		public static final String COL_ICARE_PROFILE_EYE_COLOR = "eye_color";
		public static final String COL_ICARE_PROFILE_WEIGHT = "weight";
		public static final String COL_ICARE_PROFILE_HEIGHT = "height";
		public static final String COL_ICARE_PROFILE_DATE_OF_BIRTH = "dateofbirth";
		public static final String COL_ICARE_PROFILE_SPECIFIC_PROBLEM = "specific_problem";

		

		private static final String DATABASE_NAME = "healthCare.db";
		private static final int DATABASE_VERSION = 1;

		// Database creation sql statement
		private static final String DATABASE_CREATE_PROFILE = "create table "
				+ Health_CARE_PROFILE + "( " + COL_ICARE_PROFILE_ID
				+ " integer primary key autoincrement, " + " "
				+ COL_ICARE_PROFILE_NAME + " text not null," + " "
				+ COL_ICARE_PROFILE_AGE + " text not null," + " "
				+ COL_ICARE_PROFILE_BLOOD_GROUP + " text not null," + " "
				+ COL_ICARE_PROFILE_WEIGHT + " text not null," + " "
				+ COL_ICARE_PROFILE_HEIGHT + " text not null," + " "
				+ COL_ICARE_PROFILE_DATE_OF_BIRTH + " text not null," + " "
				+ COL_ICARE_PROFILE_SPECIFIC_PROBLEM + " text not null);";

		
		public void onCreate(SQLiteDatabase database) {
			database.execSQL(DATABASE_CREATE_PROFILE);
			
		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(SQLLiteHelper.class.getName(),
					"Upgrading database from version " + oldVersion + " to "
							+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS " + Health_CARE_PROFILE);
			
			onCreate(db);
		}

		

		public void close() {
			// TODO Auto-generated method stub
			
		}

		public static SQLiteDatabase getWritableDatabase() {
			// TODO Auto-generated method stub
			return null;
		}

	}


