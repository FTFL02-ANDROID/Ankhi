package com.ftfl.icaremyself.fragment;


import com.ftfl.icaremyself.CareCenterActivity;
import com.ftfl.icaremyself.CreateDietActivity;
import com.ftfl.icaremyself.CreateProfileActivity;
import com.ftfl.icaremyself.GalleryActivity;
import com.ftfl.icaremyself.MedicalHistoryViewActivity;
import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.VaccinationViewActivity;
import com.ftfl.icaremyself.ViewDoctorProfileActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class HomeFragment extends Fragment {
	
	Button mBtnCreateProfile;
	Button mBtnDiet;
	Button mBtnVac;
	Button mBtnDrProfile;
	Button mBtnMedicalHistory;
	Button mBtnGallery;
	Button mBtnCareCenter;

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String TAG = HomeFragment.class.getSimpleName();

	public static HomeFragment newInstance() {
		return new HomeFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		/*try {
		
		String value = getArguments().getString("YourKey");
		if(value!=null){
		
		TextView te=(TextView) rootView.findViewById(R.id.textView1);
		te.setText(value);
		}} catch (Exception e) {
			// TODO: handle exception
	
		}
	*/	
		/*Intent intent = new Intent(getActivity(), mFragmentFavorite.class);
		startActivity(intent);*/
		mBtnCreateProfile = (Button)rootView.findViewById(R.id.profileButton);
		mBtnDiet = (Button)rootView.findViewById(R.id.dietButton);
		mBtnVac = (Button) rootView.findViewById(R.id.vccButton);
		mBtnDrProfile = (Button) rootView.findViewById(R.id.docprofileButton);
		mBtnMedicalHistory = (Button) rootView.findViewById(R.id.medicalhistoryButton);
		mBtnGallery = (Button) rootView.findViewById(R.id.galleryButton);
		mBtnCareCenter = (Button) rootView.findViewById(R.id.carecenterButton);
		
		
		mBtnCreateProfile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), CreateProfileActivity.class);
				startActivity(intent);

			}

			});
		
		mBtnDiet.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), CreateDietActivity.class);
				startActivity(intent);

			}

			});
		
		mBtnVac.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), VaccinationViewActivity.class);
				startActivity(intent);

			}

			});
		
		mBtnDrProfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), ViewDoctorProfileActivity.class);
				startActivity(intent);

			}

			});
		
		mBtnMedicalHistory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), MedicalHistoryViewActivity.class);
				startActivity(intent);

			}

			});
		
		mBtnGallery.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), GalleryActivity.class);
				startActivity(intent);

			}

			});
		
		mBtnCareCenter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), CareCenterActivity.class);
				startActivity(intent);

			}

			});
		
		return rootView;
        
	}

		}


	
	