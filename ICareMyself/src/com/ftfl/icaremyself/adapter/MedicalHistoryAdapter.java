package com.ftfl.icaremyself.adapter;

import java.util.ArrayList;

import com.ftfl.icaremyself.R;
import com.ftfl.icaremyself.util.MedicalProfile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


@SuppressLint("InflateParams")
public class MedicalHistoryAdapter extends ArrayAdapter<MedicalProfile> {
	
	Activity context;
	ArrayList<MedicalProfile> mMHList;
	MedicalProfile mMHPro;

	public MedicalHistoryAdapter(Activity context, ArrayList<MedicalProfile> eMHList) {

		super(context, R.layout.row_medical_history, eMHList);

		this.context = context;
		this.mMHList = eMHList;
	}
	
	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView tvPurpose;
		public TextView tvDate;
		public TextView textId;

	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		/***** Get each Model object from Array list ********/
		mMHPro = mMHList.get(position);
		ViewHolder holder = null;
		
		LayoutInflater inflater = context.getLayoutInflater();
		
		if (convertView == null) {

			convertView = inflater.inflate(R.layout.row_medical_history, null);
			holder = new ViewHolder();
			
			holder.tvPurpose = (TextView) convertView.findViewById(R.id.tvPurpose);
			holder.tvDate = (TextView) convertView.findViewById(R.id.tvDateMH);
			holder.textId = (TextView) convertView.findViewById(R.id.dbIdMH);
		
		/************ Set holder with LayoutInflater ************/
		convertView.setTag(holder);
	} else
		
		holder = (ViewHolder) convertView.getTag();
		
		holder.textId.setText(mMHPro.getId().toString()); 
		holder.tvPurpose.setText(mMHPro.getPurpose().toString());
		holder.tvDate.setText(mMHPro.getDate().toString());
		
		return convertView;
	}

}
