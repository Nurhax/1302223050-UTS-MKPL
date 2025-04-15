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
		if (grade == 1) {
			EmployeeSalaryData.setMonthlySalary(3000000);
			if (EmployeePrivate.isForeigner()) {
				EmployeeSalaryData.setMonthlySalary((int) (3000000 * 1.5));
			}
		}else if (grade == 2) {
			EmployeeSalaryData.setMonthlySalary(5000000);
			if (EmployeePrivate.isForeigner()) {
				EmployeeSalaryData.setMonthlySalary((int) (3000000 * 1.5));
			}
		}else if (grade == 3) {
			EmployeeSalaryData.setMonthlySalary(7000000);
			if (EmployeePrivate.isForeigner()) {
				EmployeeSalaryData.setMonthlySalary((int) (3000000 * 1.5));
			}
		}
	}

	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == EmployeeDatesData.getYearJoined()) {
			EmployeeDatesData.setMonthWorkingInYear(date.getMonthValue() - EmployeeDatesData.getMonthJoined());
		}else {
			EmployeeDatesData.setMonthWorkingInYear(12);
		}
		
		return TaxFunction.calculateTax(EmployeeSalaryData.getMonthlySalary(), EmployeeSalaryData.getOtherMonthlyIncome(), EmployeeDatesData.getMonthWorkingInYear(),  EmployeeSalaryData.getAnnualDeductible(), EmployeePrivate.getSpouseIdNumber().equals(""), EmployeePrivate.getChildIdNumbers().size());
	}
}
