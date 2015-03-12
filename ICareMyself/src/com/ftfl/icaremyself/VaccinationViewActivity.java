package com.ftfl.icaremyself;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.SQLiteHelper;
import com.ftfl.icaremyself.database.VaccinationDataSource;
import com.ftfl.icaremyself.model.FTFLConstants;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class VaccinationViewActivity extends Activity {

	TextView tvName = null, tvReason = null, tvDate = null, tvTime = null;
	VaccinationDataSource mSqlSource = null;
	Bundle extras = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vaccination_view);

		mSqlSource = new VaccinationDataSource(this);
		extras = getIntent().getExtras();

		tvName = (TextView) findViewById(R.id.tvVaccineName);
		tvReason = (TextView) findViewById(R.id.createDescription);
		tvDate = (TextView) findViewById(R.id.createVcDate);
		tvTime = (TextView) findViewById(R.id.createVcTime);

		if (extras != null) {
			int value = extras.getInt(FTFLConstants.KEY_ID);

			if (value > 0) {
				Cursor cursor = mSqlSource.getData(value);

				if (cursor.moveToFirst()) {

					String name = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_NAME_VC_FIELD));
					String reason = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_REASON_FIELD));
					String date = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_DATE_VC_FIELD));
					String time = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_TIME_VC_FIELD));

					tvName.setText(name);
					tvReason.setText(reason);
					tvDate.setText(date);
					tvTime.setText(time);
				}
			}
		}
	}

}
