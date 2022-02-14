<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script type="text/javascript" src="js/validation.js"></script>	
	<script type="text/javascript" src="js/employee-validation.js"></script>	
	
	<title>Add New Employee</title>	

</head>

<body>
	<div id="wrapper">
		<div>	
			<h1 class="display-3 text-center mt-3">Add New Employee To Database</h1>
		</div>
	</div>
	
	<div class="container" id="container">
		
		<form action="EmployeesController" method="POST" name="employyeeForm" onSubmit="return validateForm()">
			<input type="hidden" name="command" value="ADD" />
			
				<div class="mb-3">
					<label class="form-label">First Name:</label>
					<input name="First_Name" class="form-control"/>
				</div>
				<div class="mb-3">
					<label class="form-label">Last Name:</label>
					<input name="Last_Name" class="form-control"/>
				</div>
				<div class="mb-3">
					<label class="form-label">Job Title:</label>
					<input name="Job_Title" class="form-control"/>			
				</div>	
				<div class="mb-3">
					<label class="form-label">Email:</label>
					<input name="Email" class="form-control"/>
					
				</div>				
				<div class="mb-3">
					<label class="form-label">Test Covid:</label>
					<select name="Test_Covid" class="form-select">
        				<option>POSITIVE</option>
        				<option>NEGATIVE</option>
        				<option>UNDECIDED</option>
      				</select>
				</div>
    			<div class="d-grid gap-2 col-6 mx-auto">
					<input type="submit" value="Save" class="btn btn-dark btn-lg m-1"/>
				</div>																								
		</form>
		<div style="clear: both;"></div>
		<div class="d-grid gap-2 col-6 mx-auto">
			<a href="EmployeesController" class="btn btn-secondary btn-lg m-1">Back to Employees List</a>
		</div>
	</div>
</body>

</html>