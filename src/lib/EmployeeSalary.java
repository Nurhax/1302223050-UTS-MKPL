package lib;

import java.time.LocalDate;

public class EmployeeSalary {
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public int getMonthlySalary() {
		return monthlySalary;
	}
	
	public int getOtherMonthlyIncome() {
		return otherMonthlyIncome;
	}
	
	public int getAnnualDeductible() {
		return annualDeductible;
	}


}
