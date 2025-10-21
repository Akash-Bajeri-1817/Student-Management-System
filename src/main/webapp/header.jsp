<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TCA, Pune</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" xintegrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<!-- Include Tailwind CSS script for utility classes like bg-gray-900 -->
<script src="https://cdn.tailwindcss.com"></script>
<style>
    /* Custom style for the offcanvas background to distinguish it from the navbar */
    .offcanvas.text-bg-dark {
        background-color: #1a1a1a !important; /* Slightly lighter dark gray for distinction */
    }
</style>
</head>
<body data-bs-theme="dark">
	<!-- Applying darker gray background and blue accent border using Tailwind classes -->
	<nav class="navbar navbar-dark bg-gray-900 fixed-top border-b border-primary" style="--tw-bg-opacity: 1; --tw-border-opacity: 1;">
  <div class="container-fluid">
    <a class="navbar-brand" href="./">Techno Comp Academy, Pune</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
      <div class="offcanvas-header">
        <!-- Title color set to primary for better visibility -->
        <h5 class="offcanvas-title text-primary" id="offcanvasDarkNavbarLabel">TCA, Pune</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="./">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="./aboutus.jsp">About Us</a>
          </li> 
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Student
            </a>
            <ul class="dropdown-menu dropdown-menu-dark">
              <li><a class="dropdown-item" href="./addstudent">Add Student</a></li>
              <li><a class="dropdown-item" href="./update">Update Student</a></li>
              <li><a class="dropdown-item" href="./display">Display Student</a></li>
              <li><a class="dropdown-item" href="./delete">Delete Student</a></li>
            </ul>
          </li>
        </ul>
        
      </div>
    </div>
  </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" xintegrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
