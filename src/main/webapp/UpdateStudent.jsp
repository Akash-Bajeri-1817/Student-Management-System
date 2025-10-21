<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*, com.akash.entities.*" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update </title>
    
	
	<script type="text/javascript">
		
		function openUpdatePopUp(trno)
		{
			var tr = document.getElementById(trno)
			var td = tr.getElementsByTagName("td")
					
			var srno = td[0].textContent 
			var sname = td[1].textContent 
			var sper = td[2].textContent 
			
			document.getElementById("modalRno").value = srno
			document.getElementById("modalName").value = sname
			document.getElementById("modalPer").value = sper
			
			
			
			//alert(srno + "----" + sname + "-----" + sper)
			new bootstrap.Modal(document.getElementById("updateModal")).show()
		}
		
		function modify()
		{
			var modalRno = document.getElementById("modalRno")
			var modalName = document.getElementById("modalName")
			var modalPer = document.getElementById("modalPer")
			
			var updateSrno = modalRno.value
			var updateName = modalName.value
			var updatePer = modalPer.value
			fetch("http://localhost:8080/Student-Management-System/update",
				  {
					method : 'POST',
					body  : new URLSearchParams({"trno": updateSrno, "tname" : updateName, "tper" : updatePer})
				  }		
			)
			.then(response => response.text())
			.then(data => 
					{
						if(data.trim() == 'success')
						{
							document.querySelector("#updateModal .btn-close").click()
							//alert("Record updated successfully !!!")
							swal("Success", "Record is Updated Successfully !!!", "success")
							.then( () => location.reload() );
							
						}
						if(data.trim() == 'failed')
						{
							//alert("Failed to update records")
							swal("Failure", "Failed to Update Record", "error")
						}
					}
					
			)
			.catch( error => console.error("MyError while deleting Roll number = ") )
		}
		
		
		
	</script>
	
	
	
</head>
<body>
<div class="container" style="margin-top: 100px">
<h2 class="text-center text-primary mb-4 mt-4 fs-1">Student Information</h2>

<div class="container-fluid  d-flex  justify-content-end">
	<form action="./update" method="GET" class="d-flex  mb-4" role="search">
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
				<td><input type="submit" name="sbtn" value="UPDATE" class="btn btn-outline-primary" onclick="openUpdatePopUp(<%= s.getRno() %>)"></td>
			</tr>
<%
		}
	}
%>
</table>
</div>

<!-- Modal -->
<div class="modal" id ="updateModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
    <!-- Header -->
      <div class="modal-header bg-primary text-white">
        <h5 class="modal-title">Update Student</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <!-- Body -->
      <div class="modal-body">
        <p>Modal body text goes here.</p>
        <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Roll Number </label>
		    <input type="text" class="form-control" id="modalRno" readonly aria-describedby="emailHelp">    
 		</div>
 		<div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Student Name </label>
		    <input type="text" class="form-control" id="modalName"  aria-describedby="emailHelp">    
 		</div>
 		<div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Percentage  </label>
		    <input type="text" class="form-control" id="modalPer"  aria-describedby="emailHelp">    
 		</div>
      </div>
      
      <!-- Footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="modify()">Update changes</button>
      </div>
    </div>
  </div>
</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 
</body>
</html>