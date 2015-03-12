package com.ftfl.icaremyself.fragment;

import java.util.ArrayList;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.ViewDietActivity;
import com.ftfl.icaremyself.adapter.DietWeekAdapter;
import com.ftfl.icaremyself.database.DietDataSource;
import com.ftfl.icaremyself.model.FTFLConstants;
import com.ftfl.icaremyself.util.DietProfile;

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


public class DietWeekFragment extends Fragment {

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	ListView mListView = null;
	DietDataSource mSqlSource = null;
	DietProfile mDietPro = null;

	TextView textId = null;
	int id_To_Update = 0;

	public DietWeekFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_diet_week,
				container, false);

		mSqlSource = new DietDataSource(getActivity());

		ArrayList<DietProfile> dietProfiles = mSqlSource.getWeeklyDates();

		DietWeekAdapter adapter = new DietWeekAdapter(getActivity(), dietProfiles);

		// adding adapter to the list view.
		mListView = (ListView) rootView.findViewById(R.id.listWeek);
		mListView.setAdapter(adapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// arg1 is used to get the view. dbID1 is declared in the
				// listrow, which is hidden/gone
				textId = (TextView) arg1.findViewById(R.id.dbIDWk);
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
		Intent intent = new Intent(getActivity(), ViewDietActivity.class);
		intent.putExtras(dataBundle);
		startActivity(intent);
	}

}
