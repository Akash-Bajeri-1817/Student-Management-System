<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Add Student</title>

</head>
<body>

<div class="container" style="width: 500px; margin-top: 100px">
	<h2 class="text-center text-primary mb-4 mt-4 fs-1">Registration Form</h2>
	<form action="./addstudent" method="POST">
		
		<div class="mb-3 mt-4">
		    <label for="exampleInputEmail1" class="form-label">Roll Number </label>
		    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "rno" required>
	    </div>
	    
	    <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Name </label>
		    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "name" required>
    	</div>
    	
    	<div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Percentage </label>
		    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "per" required>
	    </div>
		
		<div class="d-grid gap-2">
			<input class="btn btn-primary" type = "submit" value = "Save">
		</div>
		
	</form>
	
		<p > ${message} <p>
</div>

</body>
</html>