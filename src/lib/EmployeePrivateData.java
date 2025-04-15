package lib;

import java.util.List;

public class EmployeePrivateData {
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber;
	}
	
	public String getSpouseIdNumber() {
		return spouseIdNumber;
	}
	
	
	public void setChildNames(List<String> childNames) {
		this.childNames = childNames;
	}
	
	public void setChildIdNumbers(List<String> childIdNumbers) {
		this.childIdNumbers = childIdNumbers;
	}
	
	public List<String> getChildIdNumbers() {
		return childIdNumbers;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public void setForeigner(boolean isForeigner) {
		this.isForeigner = isForeigner;
	}
	
	public boolean isForeigner() {
		return isForeigner;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	


}
