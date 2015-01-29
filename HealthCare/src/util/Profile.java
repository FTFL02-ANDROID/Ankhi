package util;

public class Profile {
	
	public String name;
	public String fname;
	public String mname;
	public String age;
	public String bloodGroup;
	public String eyeColor;
	public String weight;
	public String height;
	public String dateOfBirth;
	public String specificProblem;
	String id;


	/*
	 * set id of the profile
	 */
	public void setID(String iID) {
		id = iID;
	}
/*
 * get id of the activity
 */
	public String getID() {
		return id;
	}

	/*
	 * Set a name for icare profile. parameter iName return name
	 */
	public void setName(String iName) {
		name = iName;
	}
	/*
	 * get name of the icare profile.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Set a fname for icare profile. parameter iName return name
	 */
	public void setFname(String iFname) {
		fname = iFname;
	}
	/*
	 * get fname of the icare profile.
	 */
	public String getFname() {
		return fname;
	}
	
	/*
	 * Set a mname for icare profile. parameter iName return name
	 */
	public void setMname(String iMname) {
		mname = iMname;
	}
	/*
	 * get mname of the icare profile.
	 */
	public String getMname() {
		return mname;
	}
	
	
	/*
	 * set age of the person
	 */
	public void setAge(String iAge) {
		age = iAge;
	}
	/*
	 * get age of the person
	 */
	public String getAge() {
		return age;
	}
	/*
	 * set blood group of the person
	 */
	public void setBloodGroup(String eBloodGroup) {
		bloodGroup = eBloodGroup;
	}
	/*
	 * get blood group of the person
	 */
	public String getBlooGroup() {
		return bloodGroup;
		
	}
	
	/*
	 * set eye color of the person
	 */
	public void setEyeColor(String iEyeColor) {
		eyeColor = iEyeColor;
	}
	/*
	 * get fname of the icare profile.
	 */
	public String getEyeColor() {
		return eyeColor;
	}
	
/*
 * set weight
 */
	public void setWeight(String iWeight) {
		weight = iWeight;
	}
/*
 * get weight
 */
	public String getWeight() {
		return weight;
	}
/*
 * set height
 */
	public void setHeight(String iHeight) {
		height = iHeight;
	}
/*
 * get height
 */
	public String getHeight() {
		return height;
	}
	/*
	 * set date of birth
	 */
	public void setDateOfBirth(String iDateOfBirth) {
		dateOfBirth = iDateOfBirth;
	}
	/*
	 * get date of birth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/*
	 * set special notes
	 */
	public void setSpecificProblem(String iSpecificProblem) {
		specificProblem = iSpecificProblem;
	}
	/*
	 * get special notes
	 */
	public String getSpecialNotes() {
		return specificProblem;
	}



	
	/*
	 * set empty constructor of this class
	 */
	public Profile() {

	}
	/*
	 * constructor for set value
	 */
	public Profile(String mId, String icName,String icFname,String icMname, String icAge, String eBloodGroup,
			String icEyeColor,String icWeight, String icHeight, String icDateOfBirth,
			 String icSpecificProblem) {
		id = mId;
		name = icName;
		fname = icFname;
		name = icMname;
		age = icAge;
		bloodGroup = eBloodGroup;
		eyeColor = icEyeColor;
		weight = icWeight;
		height = icHeight;
		dateOfBirth = icDateOfBirth;
		
		specificProblem = icSpecificProblem;

	}
	


}


