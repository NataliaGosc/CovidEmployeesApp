function validateForm() {
	
	var theErrorFields = [];

	var employeeForm = document.forms["employeeForm"];
	
	var First_Name = employeeForm["First_Name"].value.trim();;
	if (First_Name == "") {
		theErrorFields.push("First_Name");
	}

	var Last_Name = employeeForm["Last_Name"].value.trim();;
	if (Last_Name == "") {
		theErrorFields.push("Last_Name");
	}
	
	var Job_Title = employeeForm["Job_Title"].value.trim();;
	if (Job_Title == "") {
		theErrorFields.push("Job_Title");
	}
	
	var Email = employeeForm["Email"].value.trim();;
	if (Email == "") {
		theErrorFields.push("Email");
	}
	
	var Test_Covid = employeeForm["Test_Covid"].value.trim();;
	if (Test_Covid == "") {
		theErrorFields.push("Test_Covid");
	}
	
	if (theErrorFields.length > 0) {
		alert("Form validation failed. Please add data for following fields: " + theErrorFields);
		return false;
	}
}