package com.ftfl.icaremyself.fragment;

import java.util.ArrayList;

import com.ftfl.icaremyself.CareCenterActivity;
import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.adapter.CareCenterAdapter;
import com.ftfl.icaremyself.database.CareCenterDatasSource;
import com.ftfl.icaremyself.model.FTFLConstants;
import com.ftfl.icaremyself.util.HealthCenter;

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


public class CareCenterListFragment extends Fragment {
	
	public static final String TAG = CareCenterListFragment.class.getSimpleName();

	ListView mListView = null;
	CareCenterDatasSource mSqlSource = null;
	HealthCenter mHCntrPro = null;

	String[] mName = { "Galaxy Hospital", "United Hospital", "Appolo",
			"MediNova" };
	String[] mAddress = { "Mirpur-10", "Baridhara", "Gulshan", "Dhanmondi" };
	String[] mPhn = { "0201476987", "564796", "2436", "545457" };
	Double[] mLat = { 23.65894, 23.5897, 23.1478, 23.2258 };
	Double[] mLang = { 90.32568, 90.47896, 90.25897, 90.33145 };

	TextView textId = null;
	int id_To_Update = 0;

	public static CareCenterListFragment newInstance() {
		return new CareCenterListFragment();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_care_center_list, container,
				false);

		mSqlSource = new CareCenterDatasSource(getActivity());

		HealthCenter hC_one;
		
		if(mSqlSource.profileNumber() == 0){
		for (int i = 0; i < mName.length; i++) {

			hC_one = new HealthCenter(mName[i], mAddress[i], mPhn[i], mLat[i],
					mLang[i]);
			mSqlSource.insert(hC_one);
		}
		}

		ArrayList<HealthCenter> hCntrProfiles = mSqlSource.getAllData();

		CareCenterAdapter adapter = new CareCenterAdapter(getActivity(),
				hCntrProfiles);

		// adding adapter to the list view.
		mListView = (ListView) rootView.findViewById(R.id.listHC);
		mListView.setAdapter(adapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// arg1 is used to get the view. dbID1 is declared in the
				// listrow, which is hidden/gone
				textId = (TextView) arg1.findViewById(R.id.dbIdHC);
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
		Intent intent = new Intent(getActivity(), CareCenterActivity.class);
		intent.putExtras(dataBundle);
		startActivity(intent);
	}

}


