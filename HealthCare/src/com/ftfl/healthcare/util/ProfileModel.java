package com.ftfl.healthcare.util;

public class ProfileModel {
	
	
	public String mHospitslAddress;
	public static String mHospitalName;
	public static String mLatitude;
	public static String mLongitude;
	public String mAvailableDoctorName;
	public String mAvailableDoctorNumber;
	public String mHospitalDescription;

	
	String id;
	
	public ProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfileModel(String mHospitalName, String mHospitslAddress,
			String mLatitude, String mLongitude, String mHospitalDescription,
			String mAvailableDoctorName, String mAvailableDoctorNumber, String id) {
		super();
		this.mHospitalName = mHospitalName;
		this.mHospitslAddress = mHospitslAddress;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mHospitalDescription = mHospitalDescription;
		this.mAvailableDoctorName = mAvailableDoctorName;
		this.mAvailableDoctorNumber = mAvailableDoctorNumber;
		this.id = id;
	}

	public ProfileModel(String mHospitalName, String mHospitslAddress,
			String mLatitude, String mLongitude, String mHospitalDescription,
			String mAvailableDoctorName, String mAvailableDoctorNumber ) {
		super();
		this.mHospitalName = mHospitalName;
		this.mHospitslAddress = mHospitslAddress;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mHospitalDescription = mHospitalDescription;
		this.mAvailableDoctorName = mAvailableDoctorName;
		this.mAvailableDoctorNumber = mAvailableDoctorNumber;
		
	}

	public String getmHospitalName() {
		return mHospitalName;
	}

	public void setmHospitalName(String mHospitalName) {
		this.mHospitalName = mHospitalName;
	}

	public String getmHospitslAddress() {
		return mHospitslAddress;
	}

	public void setmHospitslAddress(String mHospitslAddress) {
		this.mHospitslAddress = mHospitslAddress;
	}

	
	public String getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(String mLatitude) {
		this.mLatitude = mLatitude;
	}

	public String getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(String mLongitude) {
		this.mLongitude = mLongitude;
	}

	public String getmHospitalDescription() {
		return mHospitalDescription;
	}

	public void setmHospitalDescription(String mHospitalDescription) {
		this.mHospitalDescription = mHospitalDescription;
	}

	public String getmAvailableDoctorName() {
		return mAvailableDoctorName;
	}

	public void setmAvailableDoctorName(String mAvailableDoctorName) {
		this.mAvailableDoctorName = mAvailableDoctorName;
	}

	public String getmAvailableDoctorNumber() {
		return mAvailableDoctorNumber;
	}

	public void setmAvailableDoctorNumber(String mAvailableDoctorNumber) {
		this.mAvailableDoctorNumber = mAvailableDoctorNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	

}

