<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
		
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<title>Covid Employees App</title>
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h1 class="display-1 text-center mt-5">Covid Employees List</h1>
		</div>
	</div>
	<div  class="container" id="container">
		<div id="content">
		
		 <form action="EmployeesController" method="GET">
                <input type="hidden" name="command" value="SEARCH" />
                <p>Search Employee:</p>
                <input type="text" name="theSearchName" class="form-control" />             
                <input type="submit" value="Search" class="btn btn-dark input-group-text"/>
               	<a href="EmployeesController" class="btn btn-secondary input-group-text">Reset</a>
        </form>
		
		<div class="d-grid gap-2 col-6 mx-auto m-3">
			<input class="btn btn-secondary btn-lg" type="button" value="Add New Employee" 
			onclick="window.location.href='add_employee.jsp' ; return false;" />
		</div>
		
			<table class="table">
			<thead>
			
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Job Title</th>
				<th scope="col">Email</th>	
				<th scope="col">Test Covid</th>		
				<th scope="col">Action</th>																											
			</tr>
			
			<c:forEach var="tempEmployee" items="${COVIDEMPLOYEES_LIST}">
			<c:url var="tempLink" value="EmployeesController">
				<c:param name="command" value="LOAD" />
				<c:param name="employeeID" value="${tempEmployee.ID}" />						
			</c:url>
			<c:url var="deleteLink" value="EmployeesController">
				<c:param name="command" value="DELETE" />
				<c:param name="employeeID" value="${tempEmployee.ID}" />						
			</c:url>			
				<tr>			
					<td> ${tempEmployee.first_Name} </td>
					<td> ${tempEmployee.last_Name} </td>
					<td> ${tempEmployee.job_Title} </td>
					<td> ${tempEmployee.email} </td>
						<c:choose>
					    <c:when test="${tempEmployee.test_Covid == 'POSITIVE'}"> 
					        <td style="color: #BD2D2D;"><b>${tempEmployee.test_Covid}</b></td>	
					    </c:when>
					    <c:when test="${tempEmployee.test_Covid == 'NEGATIVE'}"> 
					    	<td style="color: #27A723;"><b>${tempEmployee.test_Covid}</b></td>	
					    </c:when>
					    <c:when test="${tempEmployee.test_Covid == 'UNDECIDED'}"> 
					        <td style="color: #EEB620 #27A723;"><b>${tempEmployee.test_Covid}</b></td>	
					    </c:when>
					  	<c:otherwise>
					  		<td> ${tempEmployee.test_Covid} </td> 
					  	</c:otherwise>
				     	</c:choose>
				        <td>	
						<a href="${tempLink}" class="btn btn-success">Update</a>
						<a href="${deleteLink}" class="btn btn-danger" onClick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>					
						</td>																															
				</tr>			
			</c:forEach>
			</thead>
			</table>	
		</div>
	</div>
</body>

</html>