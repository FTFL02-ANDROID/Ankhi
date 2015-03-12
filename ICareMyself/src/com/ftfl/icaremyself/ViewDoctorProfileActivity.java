package com.ftfl.icaremyself;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.database.DoctorDataSource;
import com.ftfl.icaremyself.database.SQLiteHelper;
import com.ftfl.icaremyself.model.FTFLConstants;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.Intents;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewDoctorProfileActivity extends Activity {

	TextView tvName = null, tvSpecial = null, tvPhn = null, tvEmail = null;
	DoctorDataSource mSqlSource = null;
	Bundle extras = null;
	String mNumber = "", mEmail = "", mPhone = "";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_doctor_profile);

		mSqlSource = new DoctorDataSource(this);
		extras = getIntent().getExtras();

		tvName = (TextView) findViewById(R.id.tvDrName);
		tvSpecial = (TextView) findViewById(R.id.viewSpecialist);
		tvPhn = (TextView) findViewById(R.id.viewContactNumber);
		tvEmail = (TextView) findViewById(R.id.viewEmail);

		if (extras != null) {
			int value = extras.getInt(FTFLConstants.KEY_ID);

			if (value > 0) {
				Cursor cursor = mSqlSource.getData(value);

				if (cursor.moveToFirst()) {

					String name = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_NAME_DR_FIELD));
					String special = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_SPECIAL_FIELD));
					String phone = cursor
							.getString(cursor
									.getColumnIndex(SQLiteHelper.COLUMNL_PHONE_DR_FIELD));
					String email = cursor.getString(cursor
							.getColumnIndex(SQLiteHelper.COLUMNL_EMAIL_FIELD));
					
					mNumber = phone;
					mEmail = email;

					tvName.setText("Dr. " + name);
					tvSpecial.setText(special);
					tvPhn.setText(phone);
					tvEmail.setText(email);
				}
			}
		}

	}
	
	public void performDCall(View view) {

		Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
				+ mNumber));
		startActivity(callIntent);
	}
	
	
	public void performAddContactl(View view) {

		// Creates a new Intent to insert a contact
		Intent intent = new Intent(Intents.Insert.ACTION);
		// Sets the MIME type to match the Contacts Provider
		intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
		intent.putExtra(Intents.Insert.EMAIL, mEmail);
		intent.putExtra(Intents.Insert.EMAIL_TYPE,
				CommonDataKinds.Email.TYPE_WORK);
		intent.putExtra(Intents.Insert.PHONE, mPhone);
		intent.putExtra(Intents.Insert.PHONE_TYPE, Phone.TYPE_WORK);
		startActivity(intent);
	}

	public void performDSms(View view) {

		Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"
				+ mNumber));
		startActivity(smsIntent);
	}

	public void performDEmail(View view) {

		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_EMAIL, new String[] { mEmail });
		i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
		i.putExtra(Intent.EXTRA_TEXT, "body of email");
		try {
			startActivity(Intent.createChooser(i, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(this, "There are no email clients installed.",
					Toast.LENGTH_SHORT).show();
		}
	}

}
