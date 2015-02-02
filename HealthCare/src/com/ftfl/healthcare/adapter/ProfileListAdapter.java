package com.ftfl.healthcare.adapter;

import java.util.List;

import com.ftfl.healthcare.R;
import com.ftfl.healthcare.util.ProfileModel;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ProfileListAdapter extends ArrayAdapter<ProfileModel>{	
	
	private static LayoutInflater inflater = null;

	@SuppressWarnings("unused")
	private final Activity context;
	List<ProfileModel> allProfile;
	
	public ProfileListAdapter(Activity context,List<ProfileModel> allProfile) {
		
		super(context, R.layout.activity_view_profile, allProfile);
		this.context = context;
		this.allProfile = allProfile;
		
		/*********** Layout inflator to call external xml layout () ***********/
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView tvId;
		public TextView tvHospitalName;
		public TextView tvHospitalAddress;
		public TextView tvLatitude;
		public TextView tvLongitude;
		public TextView tvHospitalDescription;
		public TextView tvAvailableDoctorName;
		public TextView tvAvailableDoctorNumber;

	}
	
	@SuppressLint("InflateParams") @Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		ViewHolder holder;
		if (convertView == null) {

			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			v = inflater.inflate(R.layout.activity_view_profile, null);

			/****** View Holder Object to contain tabitem.xml file elements ******/

			holder = new ViewHolder();
			
			holder.tvId = (TextView) v.findViewById(R.id.viewHospitalId);
			holder.tvHospitalName = (TextView) v.findViewById(R.id.viewHospitalName);
			holder.tvHospitalAddress = (TextView) v.findViewById(R.id.viewHospitalAddress);
			holder.tvLatitude = (TextView) v.findViewById(R.id.viewLatitude);
			holder.tvLongitude = (TextView) v.findViewById(R.id.viewLongitude);
			holder.tvHospitalDescription = (TextView) v.findViewById(R.id.viewHospitalDescription);
			holder.tvAvailableDoctorName = (TextView) v.findViewById(R.id.viewAvailableDoctorName);
			holder.tvAvailableDoctorNumber = (TextView) v.findViewById(R.id.viewAvailableDoctorNumber);

			/************ Set holder with LayoutInflater ************/
			v.setTag(holder);
			
		} else
			holder = (ViewHolder) v.getTag();

		ProfileModel mProfile;
		
		mProfile = allProfile.get(position);

		holder.tvId.setText(mProfile.getId().toString());		
		holder.tvHospitalName.setText(mProfile.getmHospitalName().toString());
		holder.tvHospitalAddress.setText(mProfile.getmHospitslAddress().toString());
		holder.tvHospitalDescription.setText(mProfile.getmHospitalDescription().toString());
		holder.tvLatitude.setText(mProfile.getmLatitude().toString());		
		holder.tvLongitude.setText(mProfile.getmLongitude().toString());
		holder.tvAvailableDoctorName.setText(mProfile.getmAvailableDoctorName().toString());
		holder.tvAvailableDoctorNumber.setText(mProfile.getmAvailableDoctorNumber().toString());

		return v;
	}

}



