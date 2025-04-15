package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	//Data Tanggal Employee Disimpan Pada Class EmployeeDates
	private EmployeeDates EmployeeDatesData;
	//Data Pribadi Employee Disimpan Pada Class EmployeeFamily
	private EmployeePrivateData EmployeePrivate;
	//Data Gaji Employee Disimpan Pada Class Employee Salary
	private EmployeeSalary EmployeeSalaryData;

	
	
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, EmployeeDates DatesData, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		
		this.EmployeeDatesData = DatesData;
		
		EmployeePrivate.setGender(gender);
		EmployeePrivate.setForeigner(isForeigner);
		EmployeePrivate.setChildNames(new LinkedList<String>());
		EmployeePrivate.setChildIdNumbers(new LinkedList<String>());
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {
		int baseSalary = getBaseSalary(grade);
		
		if(EmployeePrivate.isForeigner()) {
			baseSalary *= 1.5;
		}
		
		EmployeeSalaryData.setMonthlySalary((int) baseSalary);
	}
	

	public int getAnnualIncomeTax() {
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		getMonthWorkingInYear();
		return TaxFunction.calculateTax(EmployeePrivate, EmployeeDatesData, EmployeeSalaryData);
	}
	
	private int getBaseSalary(int grade) {
		if(grade == 1) {
			return 3000000;
		}else if(grade == 2) {
			return 5000000;
		}else if(grade == 3) {
			return 7000000;
		}
		
		//Mengembalikan -1 jika grade jika tidak valid
		return -1;
	}
	
	private void getMonthWorkingInYear() {
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == EmployeeDatesData.getYearJoined()) {
			EmployeeDatesData.setMonthWorkingInYear(date.getMonthValue() - EmployeeDatesData.getMonthJoined());
		}else {
			EmployeeDatesData.setMonthWorkingInYear(12);
		}
	}

}
