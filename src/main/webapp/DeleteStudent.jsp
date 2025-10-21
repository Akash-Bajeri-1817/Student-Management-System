<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*, com.akash.entities.*" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Delete </title>
    
	
	<script type="text/javascript">
		function del(srno)
		{
			var status = confirm("Do you want to delete STUDENT for Roll Number : " + srno)
			
			if(status == true)
			{
				fetch(
					"http://localhost:8080/Student-Management-System/delete",
					{
						method: "POST",
						body  : new URLSearchParams({"trno": srno})
					}
				)
				.then(response => response.text())
				.then( data =>
						{
							if(data.trim() == "success")
							{
								//alert("Record is Deleted for Roll Number : " + srno)
								swal("Success", "Record is Deleted Successfully !!!", "success")
								var tr = document.getElementById(srno)
								tr.remove()
							}
							if(data.trim() == "failed")
							{
								swal("Failure", "Failed to  Delete Record : ", "error")
								//alert("Failed to  Deleted for Roll Number : " + srno)
							}
						}
				)
				.catch( error => console.error("MyError while deleting Roll number = "+srno))
				
			}
			
		}
		
	</script>
	
	
	
</head>
<body>
<div class="container" style="margin-top: 100px">
<h2 class="text-center text-primary mb-4 mt-4 fs-1">Student Information</h2>

<div class="container-fluid  d-flex  justify-content-end">
	<form action="./delete" method="GET" class="d-flex  mb-4" role="search">
	<input type="search" name="srno" class="form-control me-3" placeholder="Search here">
	<input type="submit" name="sbtn" value="Search" class="btn btn-outline-success me-3">
	<input type="submit" name="sbtn" value="Refresh" class="btn btn-outline-success">
	</form>
	
</div>

<table class="table table-hover table-bordered text-center ">
<tr class="table-primary">
	<th> ROLL NUMBER </th><th> NAME </th> <th> PERCENTAGE </th><th>ACTION</th>
</tr>
<%
	List<Student> L = (List<Student>)request.getAttribute("students");
	
	if(L.isEmpty())
	{
%>
		<tr>
			<td colspan="4" class="text-danger bg-danger-subtle"> No Data Found !!!</td>
		</tr>
<% 
	}
	else
	{
		for(Student s: L)
		{
%>
			<tr id="<%= s.getRno() %>">
				<td><%= s.getRno() %></td>
				<td><%= s.getName() %></td>
				<td><%= s.getPer()  %></td>
				<td><input type="submit" name="sbtn" value="DELETE" class="btn btn-outline-danger" onclick="del(<%= s.getRno() %>)"></td>
			</tr>
<%
		}
	}
%>
</table>
</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>