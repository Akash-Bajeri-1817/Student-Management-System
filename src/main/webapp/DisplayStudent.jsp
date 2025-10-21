<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*, com.akash.entities.*" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Display </title>
   
</head>
<body>
<div class="container" style=" margin-top: 100px">
<h2 class="text-center text-primary mb-4 mt-4 fs-1">Student Information</h2>

<div class="container-fluid  d-flex  justify-content-end">
	<form action="./display" method="GET" class="d-flex  mb-4" role="search">
	<input type="search" name="srno" class="form-control me-3" placeholder="Search here">
	<input type="submit" name="sbtn" value="Search" class="btn btn-outline-success me-3">
	<input type="submit" name="sbtn" value="Refresh" class="btn btn-outline-success">
	</form>
	
</div>

<table class="table table-hover table-bordered text-center ">
<tr class="table-primary">
	<th> ROLL NUMBER</th><th> NAME </th> <th> PERCENTAGE</th>
</tr>
<%
	List<Student> L = (List<Student>)request.getAttribute("students");
	
	if(L.isEmpty())
	{
%>
		<tr>
			<td colspan="3" class="text-danger bg-danger-subtle"> No Data Found !!!</td>
		</tr>
<% 
	}
	else
	{
		for(Student s: L)
		{
%>
			<tr>
				<td><%= s.getRno() %></td>
				<td><%= s.getName() %></td>
				<td><%= s.getPer() %></td>
			</tr>
<%
		}
	}
%>
</table>
</div>

</body>
</html>