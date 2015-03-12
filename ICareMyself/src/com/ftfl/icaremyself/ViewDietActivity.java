package com.ftfl.icaremyself;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.DietDataSource;
import com.ftfl.icaremyself.database.SQLiteHelper;
import com.ftfl.icaremyself.model.FTFLConstants;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDietActivity extends Activity {

	TextView tvName = null, tvMenue = null, tvDate = null, tvTime = null;
	ImageView mAlarm = null;
	DietDataSource mSqlSource = null;
	Bundle extras = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_diet);

		mSqlSource = new DietDataSource(this);
		extras = getIntent().getExtras();

		tvName = (TextView) findViewById(R.id.tvMealDtv);
		tvMenue = (TextView) findViewById(R.id.tvMenuDtv);
		tvDate = (TextView) findViewById(R.id.tvDateDtv);
		tvTime = (TextView) findViewById(R.id.tvTimeDtv);
		mAlarm = (ImageView) findViewById(R.id.alarm);

		if (extras != null) {
			int value = extras.getInt(FTFLConstants.KEY_ID);

			if (value > 0) {
				Cursor cursor = mSqlSource.getData(value);

				if (cursor.moveToFirst()) {

					String name = cursor
							.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_NAME_DT_FIELD));
					String date = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_DATE_FIELD));
					String time = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_TIME_FIELD));
					String menu = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_MENU_FIELD));
					String alarm = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_ALARM_FIELD));
					
					int eAlarm = Integer.parseInt(alarm);
					
					if(eAlarm == 1){
						mAlarm.setVisibility(0);
					}

					tvName.setText(name);
					tvMenue.setText(menu);
					tvDate.setText(date);
					tvTime.setText(time);
				}
			}
		}
	}

}
