package com.ftfl.icaremyself;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.MedicalHistoryDataSource;
import com.ftfl.icaremyself.database.SQLiteHelper;
import com.ftfl.icaremyself.model.FTFLConstants;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MedicalHistoryViewActivity extends Activity {

	TextView tvName = null, tvPurpose = null, tvDateTime = null;
	ImageView mPhoto = null;
	MedicalHistoryDataSource mSqlSource = null;
	Bundle extras = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medical_history_view);

		mSqlSource = new MedicalHistoryDataSource(this);
		extras = getIntent().getExtras();

		tvName = (TextView) findViewById(R.id.tvDoctorName);
		tvPurpose = (TextView) findViewById(R.id.tvDescription);
		tvDateTime = (TextView) findViewById(R.id.tvVisitedDate);
		mPhoto = (ImageView) findViewById(R.id.ivImage);

		if (extras != null) {
			int value = extras.getInt(FTFLConstants.KEY_ID);

			if (value > 0) {
				Cursor cursor = mSqlSource.getData(value);

				if (cursor.moveToFirst()) {

					String name = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_NAME_MH_FIELD));
					String purpose = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_PURPOSE_FIELD));
					String date = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_DATE_MH_FIELD));
					String time = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_TIME_MH_FIELD));
					String photo = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_PHOTO_FIELD));

					if (photo != null) {
						BitmapFactory.Options options = new BitmapFactory.Options();
						// down sizing image
						options.inSampleSize = 2;
						Bitmap bitmap = BitmapFactory
								.decodeFile(photo, options);

						mPhoto.setImageBitmap(bitmap);
					}

					tvName.setText("Dr. " + name);
					tvPurpose.setText(purpose);
					tvDateTime.setText(date + "  " + time);
				}
			}
		}
	}

}
