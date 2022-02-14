package com.covidemployees.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeesDbUntil {

	private DataSource dataSource;
	
	public EmployeesDbUntil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Employee> getEmployees() throws Exception {
		
		List<Employee> employees = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from CovEmployees";			
			myStmt = myConn.createStatement();			
			myRs = myStmt.executeQuery(sql);			
			
			while (myRs.next()) {
				
				int iD = myRs.getInt("ID");
				String first_Name = myRs.getString("First_Name");
				String last_Name = myRs.getString("Last_Name");
				String job_Title = myRs.getString("Job_Title");
				String email = myRs.getString("Email");
				String test_Covid = myRs.getString("Test_Covid");	
				
				Employee tempEmployee = new Employee(iD, first_Name, last_Name, job_Title, email, test_Covid);
				
				employees.add(tempEmployee);
			}
			
			return employees;
		}
		finally {
			close(myConn, myStmt, myRs);
		}	
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			if (myConn != null) {
				myConn.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myRs != null) {
				myRs.close();
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}		
	}

	public void addEmployee(Employee theEmployee) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			
			myConn = dataSource.getConnection();
			
			String sql = "insert into CovEmployees"
					   + "(First_Name, Last_Name, Job_Title, Email, Test_Covid)"
					   + "values (?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEmployee.getFirst_Name());
			myStmt.setString(2, theEmployee.getLast_Name());
			myStmt.setString(3, theEmployee.getJob_Title());
			myStmt.setString(4, theEmployee.getEmail());			
			myStmt.setString(5, theEmployee.getTest_Covid());
			
			myStmt.execute();
			
		}
		finally {
			close(myConn, myStmt, null);
		}
	}

	public Employee getEmployee(String theEmployeeID) throws Exception {

		Employee theEmployee = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int employeeID;
		
		try {
			employeeID = Integer.parseInt(theEmployeeID);
			
			myConn = dataSource.getConnection();
			
			String sql = "select * from CovEmployees where ID=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, employeeID);
			
			myRs = myStmt.executeQuery();
			
			if (myRs.next()) {
				
				String first_Name = myRs.getString("First_Name");
				String last_Name = myRs.getString("Last_Name");
				String job_Title = myRs.getString("Job_Title");
				String email = myRs.getString("Email");
				String test_Covid = myRs.getString("Test_Covid");	
				
				theEmployee = new Employee(employeeID, first_Name, last_Name, job_Title, email, test_Covid);
			}
			else {
				throw new Exception("Could not find employee ID: " + employeeID);
			}
			return theEmployee;			
		}
		finally {
			
		}
	}

	public void updateEmployee(Employee theEmployee) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();

			String sql = "update CovEmployees"
					   + "set First_Name=?, Last_Name=?, Job_Title=?, Email=?, Test_Covid=?"
					   + "where ID=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEmployee.getFirst_Name());
			myStmt.setString(2, theEmployee.getLast_Name());
			myStmt.setString(3, theEmployee.getJob_Title());
			myStmt.setString(4, theEmployee.getEmail());			
			myStmt.setString(5, theEmployee.getTest_Covid());
			myStmt.setInt(6, theEmployee.getID());
			
			myStmt.execute();	
		}
		finally {
			close(myConn, myStmt, null);
		}
	}

	public void deleteEmployee(String theEmployeeID)  throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {

			int employeeID = Integer.parseInt(theEmployeeID);
			

			myConn = dataSource.getConnection();
			

			String sql = "delete from CovEmployees where ID=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, employeeID);
			
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
		}	
	}

	public List<Employee> searchEmployees(String theSearchName) throws Exception {

        List<Employee> employees = new ArrayList<>();
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

		
        try {
        	
            myConn = dataSource.getConnection();
            
            if (theSearchName != null && theSearchName.trim().length() > 0) {
            	
            	String sql = "select * from CovEmployees where lower(First_Name) like ? or lower(Last_Name) like ? or lower(Job_Title) like ? or lower(Email) like ? or lower(Test_Covid) like ?";
            	
                myStmt = myConn.prepareStatement(sql);
                
                String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
                
                myStmt.setString(1, theSearchNameLike);
                myStmt.setString(2, theSearchNameLike);
                myStmt.setString(3, theSearchNameLike);
                myStmt.setString(4, theSearchNameLike);
                myStmt.setString(5, theSearchNameLike);
            }
            else {
                String sql = "select * from CovidEmployees order by ID";
                
                myStmt = myConn.prepareStatement(sql);
            }
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
            	
                int iD = myRs.getInt("ID");
				String first_Name = myRs.getString("First_Name");
				String last_Name = myRs.getString("Last_Name");
				String job_Title = myRs.getString("Job_Title");
				String email = myRs.getString("Email");
				String test_Covid = myRs.getString("Test_Covid");	
            	
				Employee tempEmployee = new Employee (iD, first_Name, last_Name, job_Title, email, test_Covid);
				
                employees.add(tempEmployee);
            }
            return employees;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
	}
}