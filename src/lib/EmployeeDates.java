package lib;

public class EmployeeDates {
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;
	
	public EmployeeDates() {};
	
	public EmployeeDates(int yearJoined, int monthJoined, int dayJoined, int monthWorkingInYear) {
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.monthWorkingInYear = monthWorkingInYear;
	}
	
	public int getYearJoined() {
		return yearJoined;
	}
	public int getMonthJoined() {
		return monthJoined;
	}
	
	public int getMonthWorkingInYear() {
		return monthWorkingInYear;
	}
	
	public void setMonthWorkingInYear(int monthWorkingInYear) {
		this.monthWorkingInYear = monthWorkingInYear;
	}
	
	
}
