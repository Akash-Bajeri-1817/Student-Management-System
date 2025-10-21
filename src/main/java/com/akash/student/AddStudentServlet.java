package com.akash.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("./AddStudent.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String message = "";
		
		Integer rno = Integer.parseInt(request.getParameter("rno"));
		String name = request.getParameter("name");
		Double per = Double.parseDouble(request.getParameter("per"));
		
		// database logic
		Connection con = null;
		PreparedStatement prestmt = null;
		
		final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb20";
		final String DB_USER = "root";
		final String DB_PWD = "root";
		final String DB_DRIVER = "org.postgresql.Driver";
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			con.setAutoCommit(false);
			prestmt = con.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?)");
			prestmt.setInt(1, rno);
			prestmt.setString(2, name);
			prestmt.setDouble(3, per);
			
			prestmt.executeUpdate();
			con.commit();
			
			message = "<div class='alert alert-success mt-3 text-center' role='alert' >Registration Successfully for Roll Number : " +rno +"</div>"; 
		}
		catch(Exception e)
		{
			message = "<div class='alert alert-danger mt-3 text-center' role='alert' >Registration Failed !!!: </div>"; 
			e.printStackTrace();
			
			try 
			{
				con.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		
		// Redirecting message to view layer
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("./AddStudent.jsp");
		rd.forward(request, response);
			
		out.close();
	}

}
