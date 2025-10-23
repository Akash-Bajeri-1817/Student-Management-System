package com.akash.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.akash.entities.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		/*
		final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb20";
		final String DB_USER = "root";
		final String DB_PWD = "root";
		final String DB_DRIVER = "org.postgresql.Driver";
		*/
		
		/*
		 * final String DB_URL =
		 * "jdbc:postgresql://ep-dawn-credit-a1771p9h-pooler.ap-southeast-1.aws.neon.tech/neondb";
		 * final String DB_USER = "neondb_owner"; final String DB_PWD =
		 * "npg_DqU1wCsZK2Sr"; final String DB_DRIVER = "org.postgresql.Driver";
		 */
		
		final String DB_URL = "jdbc:postgresql://db.pdkjlqfbrcgjzpvomssd.supabase.co/postgres";
		final String DB_USER = "postgres";
		final String DB_PWD = "BpxBhrOF3haCZAir";
		final String DB_DRIVER = "org.postgresql.Driver";
		
		String qry = "";
		String srno = request.getParameter("srno");
		String sbtn = request.getParameter("sbtn");
		
		if( sbtn == null || srno.isEmpty() || sbtn.equals("Refresh") )
			qry = "SELECT * FROM STUDENT ORDER BY RNO";
		else if(sbtn.equals("Search"))
			qry = "SELECT * FROM STUDENT WHERE RNO ="+srno;
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			prestmt = con.prepareStatement(qry);
			rs = prestmt.executeQuery();
			List<Student> L = new ArrayList<>();
			
			while(rs.next())
			{
				L.add(new Student(rs.getInt("rno"), rs.getString("name"), rs.getDouble("per")));
				//out.println(rs.getInt("rno")+ "-----" + rs.getString("name") + "-----" + rs.getDouble("per")+ "<br>");
			}
			
			// Redirecting List of Students to view layer
			request.setAttribute("students", L);
			RequestDispatcher rd = request.getRequestDispatcher("./DeleteStudent.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		PreparedStatement prestmt = null;
		
		/*
		final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb20";
		final String DB_USER = "root";
		final String DB_PWD = "root";
		final String DB_DRIVER = "org.postgresql.Driver";
		*/
		
		/*
		 * final String DB_URL =
		 * "jdbc:postgresql://ep-dawn-credit-a1771p9h-pooler.ap-southeast-1.aws.neon.tech/neondb";
		 * final String DB_USER = "neondb_owner"; final String DB_PWD =
		 * "npg_DqU1wCsZK2Sr"; final String DB_DRIVER = "org.postgresql.Driver";
		 */
		
		final String DB_URL = "jdbc:postgresql://db.pdkjlqfbrcgjzpvomssd.supabase.co/postgres";
		final String DB_USER = "postgres";
		final String DB_PWD = "BpxBhrOF3haCZAir";
		final String DB_DRIVER = "org.postgresql.Driver";
		
		String trno = request.getParameter("trno");
		String query = "delete from student where rno="+trno;
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			prestmt = con.prepareStatement(query);
			prestmt.executeUpdate();
			
			out.println("success");
		}
		catch(Exception e)
		{
			out.println("failed");
			e.printStackTrace();
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
	}

}
