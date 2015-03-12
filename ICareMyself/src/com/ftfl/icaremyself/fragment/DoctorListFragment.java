package com.ftfl.icaremyself.fragment;

import java.util.ArrayList;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.ViewDoctorProfileActivity;
import com.ftfl.icaremyself.adapter.DoctorAdapter;
import com.ftfl.icaremyself.database.DoctorDataSource;
import com.ftfl.icaremyself.model.FTFLConstants;
import com.ftfl.icaremyself.util.DoctorProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class DoctorListFragment extends Fragment {
	
	public static final String TAG = DoctorListFragment.class.getSimpleName();

	ListView mListView = null;
	DoctorDataSource mSqlSource = null;
	DoctorProfile mDrPro = null;

	TextView textId = null;
	int id_To_Update = 0;
	
	public static DoctorListFragment newInstance() {
		return new DoctorListFragment();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_doctor_list,
				container, false);

		mSqlSource = new DoctorDataSource(getActivity());

		ArrayList<DoctorProfile> drProfiles = mSqlSource.getAllData();

		DoctorAdapter adapter = new DoctorAdapter(getActivity(), drProfiles);

		// adding adapter to the list view.
		mListView = (ListView) rootView.findViewById(R.id.listDoctor);
		mListView.setAdapter(adapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// arg1 is used to get the view. dbID3 is declared in the
				// listrow, which is hidden/gone
				textId = (TextView) arg1.findViewById(R.id.dbIdDr);
				String proID = textId.getText().toString();
				// in order to use for view, delete and edit in DataBase
				id_To_Update = Integer.parseInt(proID);
				
				viewProfile(id_To_Update);

			}
		});
		
		return rootView;
	}
	
	public void viewProfile(int profileID) {

		Bundle dataBundle = new Bundle();
		dataBundle.putInt(FTFLConstants.KEY_ID, profileID); // "id" is the
															// key...
		Intent intent = new Intent(getActivity(),
				ViewDoctorProfileActivity.class);
		intent.putExtras(dataBundle);
		startActivity(intent);
	}

}


