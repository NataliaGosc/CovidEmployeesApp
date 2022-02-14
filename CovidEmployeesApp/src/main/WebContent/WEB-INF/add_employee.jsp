<!DOCTYPE html>
<html>

<head>
	<title>Add New Employee</title>

	<link type="text/css" rel="stylesheet" href="css/style.css" >
	<link type="text/css" rel="stylesheet" href="css/add_employee_style.css" >

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Covid Employees App</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add New Employee</h3>
		
		<form action="EmployeesController" method="POST">
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
				<tr>
					<td><label>First Name:</label></td>
					<td><input type="text" name="First_Name"/></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Last Name:</label></td>
					<td><input type="text" name="Last_Name"/></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Job Title:</label></td>
					<td><input type="text" name="Job_Title"/></td>
					<td></td>
				</tr>	
				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="Email"/></td>
					<td></td>
				</tr>				
				<tr>
					<td><label>Test Covid:</label></td>
					<td><input type="text" name="Test_Covid"/></td>
					<td></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" name="Save" class="save"/></td>
					<td></td>
				</tr>																									
				</tbody>
			</table>
		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="EmployeesController">Back to Employees List</a>
		</p>
	</div>
</body>

</html>