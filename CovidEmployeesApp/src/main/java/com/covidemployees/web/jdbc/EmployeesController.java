package com.covidemployees.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class EmployeesController
 */
@WebServlet("/EmployeesController")
public class EmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeesDbUntil employeesDbUntil;
	
	@Resource(name="jdbc/CovidEmployees")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
		employeesDbUntil = new EmployeesDbUntil(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		try {
			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			switch (theCommand) {
			
			case "LIST":
				listEmployees(request,response);
				break;
				
			case "LOAD":
				loadEmployee(request,response);
				break;
				
			case "UPDATE":
				updateEmployee(request,response);
				break;
				
			case "DELETE":
				deleteEmployee(request,response);
				break;		
				
			case "SEARCH":
                searchEmployee(request, response);
                break;
				
			default:
				listEmployees(request,response);
			}
		}
		catch (Exception e) {
			throw new ServletException(e);
	}
}

	private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String theSearchName = request.getParameter("theSearchName");
        
        List<Employee> employees = employeesDbUntil.searchEmployees(theSearchName);
        
        request.setAttribute("EMPLOYEE_LIST", employees);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/covidemployees_list.jsp");
        dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String theCommand = request.getParameter("command");
					

			switch (theCommand) {
							
			case "ADD":
				addEmployee(request, response);
				break;
								
			default:
				listEmployees(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String theEmployeeID = request.getParameter("employeeID");
		

		employeesDbUntil.deleteEmployee(theEmployeeID);
		
		listEmployees(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int iD = Integer.parseInt(request.getParameter("employeeID"));		
		String first_Name = request.getParameter("First_Name");
		String last_Name = request.getParameter("Last_Name");
		String job_Title = request.getParameter("Job_Title");
		String email = request.getParameter("Email");
		String test_Covid = request.getParameter ("Test_Covid");
		
		Employee theEmployee = new Employee(iD,first_Name, last_Name, job_Title,  email, test_Covid);
		
		employeesDbUntil.updateEmployee(theEmployee);
		
		listEmployees(request, response);
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String theEmployeeID = request.getParameter("employeeID");
		Employee theEmployee = employeesDbUntil.getEmployee(theEmployeeID);
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/employee_update.jsp");
		dispatcher.forward(request, response);	
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String first_Name = request.getParameter("First_Name");
		String last_Name = request.getParameter("Last_Name");
		String job_Title = request.getParameter("Job_Title");
		String email = request.getParameter("Email");
		String test_Covid = request.getParameter ("Test_Covid");
		
		Employee theEmployee = new Employee(first_Name, last_Name, job_Title,  email, test_Covid);
		
		employeesDbUntil.addEmployee(theEmployee);
		
		response.sendRedirect(request.getContextPath() + "/EmployeesController?command=LIST");
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Employee> employees = employeesDbUntil.getEmployees();
		
		request.setAttribute("COVIDEMPLOYEES_LIST", employees);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/covidemployees_list.jsp");
		dispatcher.forward(request, response);
	}
}