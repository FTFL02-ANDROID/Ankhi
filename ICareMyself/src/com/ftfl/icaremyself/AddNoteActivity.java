package com.ftfl.icaremyself;

import java.util.Calendar;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.NoteDataSource;
import com.ftfl.icaremyself.model.FTFLConstants;
import com.ftfl.icaremyself.util.NoteProfile;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends Activity implements OnDateSetListener {
		
		EditText etNote = null, etDate = null;
		String mNote = "", mDate = "";
		NoteProfile mNProfile = null;
		NoteDataSource mSqlSource = null;
		
		final Calendar mCalendar = Calendar.getInstance();

		int mYear = 0;
		int mDay = 0;
		int mMonth = 0;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_add_note);
			
			mSqlSource = new NoteDataSource(this);
			
			etNote = (EditText) findViewById(R.id.etNote);
			etDate = (EditText) findViewById(R.id.etDateNote);
			
		}
		
		public void saveNote(View view) {
			
			mNote = etNote.getText().toString();
			mDate = etDate.getText().toString();
			
			mNProfile = new NoteProfile(mNote, mDate);
			
			long inserted = mSqlSource.insert(mNProfile);

			if (inserted >= 0) {
				Toast.makeText(getApplicationContext(), FTFLConstants.INSERT_DONE,
						Toast.LENGTH_LONG).show();
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			} else
				Toast.makeText(getApplicationContext(), FTFLConstants.INSERT_PRBLM,
						Toast.LENGTH_LONG).show();
		}
		
		public void setDate(View view) {

			mYear = mCalendar.get(Calendar.YEAR);
			mMonth = mCalendar.get(Calendar.MONTH);
			mDay = mCalendar.get(Calendar.DAY_OF_MONTH);

			DatePickerDialog dialog = new DatePickerDialog(AddNoteActivity.this,
					this, mYear, mMonth, mDay);
			dialog.show();

		}

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			
			etDate.setText(new StringBuilder()
			// Month is 0 based so add 1
			.append(dayOfMonth).append("/").append(monthOfYear + 1)
			.append("/").append(year));
			
		}

	}
