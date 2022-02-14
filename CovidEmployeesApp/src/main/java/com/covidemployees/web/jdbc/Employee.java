package com.covidemployees.web.jdbc;


public class Employee {
	
	private int ID;
	private String First_Name;
	private String Last_Name;
	private String Job_Title;
	private String Email;
	private String Test_Covid;
	
	public Employee(String first_Name, String last_Name, String job_Title, String email, String test_Covid) {
		First_Name = first_Name;
		Last_Name = last_Name;
		Job_Title = job_Title;
		Email = email;
		Test_Covid = test_Covid;
	}

	public Employee(int iD, String first_Name, String last_Name, String job_Title, String email, String test_Covid) {
		ID = iD;
		First_Name = first_Name;
		Last_Name = last_Name;
		Job_Title = job_Title;
		Email = email;
		Test_Covid = test_Covid;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getJob_Title() {
		return Job_Title;
	}

	public void setJob_Title(String job_Title) {
		Job_Title = job_Title;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTest_Covid() {
		return Test_Covid;
	}

	public void setTest_Covid(String test_Covid) {
		Test_Covid = test_Covid;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Job_Title=" + Job_Title
				+ ", Email=" + Email + ", Test_Covid=" + Test_Covid + "]";
	}

}
