/*
 * package com.akash.student;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.util.ArrayList; import java.util.List;
 * 
 * import com.akash.entities.Student;
 * 
 * import jakarta.servlet.RequestDispatcher; import
 * jakarta.servlet.ServletException; import
 * jakarta.servlet.annotation.WebServlet; import
 * jakarta.servlet.http.HttpServlet; import
 * jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * 
 * @WebServlet("/update") public class UpdateStudentServlet extends HttpServlet
 * { private static final long serialVersionUID = 1L;
 * 
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
 * 
 * Connection con = null; PreparedStatement prestmt = null; ResultSet rs = null;
 * 
 * 
 * final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb20"; final String
 * DB_USER = "root"; final String DB_PWD = "root"; final String DB_DRIVER =
 * "org.postgresql.Driver";
 * 
 * 
 * final String DB_URL =
 * "jdbc:postgresql://db.pdkjlqfbrcgjzpvomssd.supabase.co:6543/postgres"; final
 * String DB_USER = "postgres"; final String DB_PWD = "BpxBhrOF3haCZAir"; final
 * String DB_DRIVER = "org.postgresql.Driver";
 * 
 * String qry = ""; String srno = request.getParameter("srno"); String sbtn =
 * request.getParameter("sbtn");
 * 
 * if( sbtn == null || srno.isEmpty() || sbtn.equals("Refresh") ) qry =
 * "SELECT * FROM STUDENT ORDER BY RNO"; else if(sbtn.equals("Search")) qry =
 * "SELECT * FROM STUDENT WHERE RNO ="+srno;
 * 
 * try { Class.forName(DB_DRIVER); con = DriverManager.getConnection(DB_URL,
 * DB_USER, DB_PWD); prestmt = con.prepareStatement(qry); rs =
 * prestmt.executeQuery(); List<Student> L = new ArrayList<>();
 * 
 * while(rs.next()) { L.add(new Student(rs.getInt("rno"), rs.getString("name"),
 * rs.getDouble("per"))); //out.println(rs.getInt("rno")+ "-----" +
 * rs.getString("name") + "-----" + rs.getDouble("per")+ "<br>"); }
 * 
 * // Redirecting List of Students to view layer
 * request.setAttribute("students", L); RequestDispatcher rd =
 * request.getRequestDispatcher("./UpdateStudent.jsp"); rd.forward(request,
 * response); } catch(Exception e) { e.printStackTrace(); } finally { try {
 * con.close(); } catch (SQLException e) { e.printStackTrace(); } }
 * 
 * }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
 * 
 * Connection con = null; PreparedStatement prestmt = null;
 * 
 * 
 * final String DB_URL = "jdbc:postgresql://localhost:5432/ajdb20"; final String
 * DB_USER = "root"; final String DB_PWD = "root"; final String DB_DRIVER =
 * "org.postgresql.Driver";
 * 
 * 
 * final String DB_URL =
 * "jdbc:postgresql://ep-dawn-credit-a1771p9h-pooler.ap-southeast-1.aws.neon.tech/neondb";
 * final String DB_USER = "neondb_owner"; final String DB_PWD =
 * "npg_DqU1wCsZK2Sr"; final String DB_DRIVER = "org.postgresql.Driver";
 * 
 * 
 * final String DB_URL =
 * "jdbc:postgresql://db.pdkjlqfbrcgjzpvomssd.supabase.co/postgres"; final
 * String DB_USER = "postgres"; final String DB_PWD = "BpxBhrOF3haCZAir"; final
 * String DB_DRIVER = "org.postgresql.Driver";
 * 
 * String trno = request.getParameter("trno"); String tper =
 * request.getParameter("tper"); String tname = request.getParameter("tname");
 * String query = "UPDATE STUDENT SET name='" + tname + "', per = "+tper+
 * " WHERE rno = "+trno;
 * 
 * try { Class.forName(DB_DRIVER); con = DriverManager.getConnection(DB_URL,
 * DB_USER, DB_PWD); prestmt = con.prepareStatement(query);
 * prestmt.executeUpdate();
 * 
 * out.println("success"); } catch(Exception e) { out.println("failed");
 * e.printStackTrace(); } finally { try { con.close(); } catch (SQLException e)
 * { e.printStackTrace(); } } }
 * 
 * }
 */

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


@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*private static final String DB_URL = "jdbc:postgresql://db.pdkjlqfbrcgjzpvomssd.supabase.co:5432/postgres?sslmode=require";
	private static final String DB_USER = "postgres";
	private static final String DB_PWD = "BpxBhrOF3haCZAir";
	private static final String DB_DRIVER = "org.postgresql.Driver";
*/
	final String DB_URL ="jdbc:postgresql://ep-misty-sound-a1oah7m7-pooler.ap-southeast-1.aws.neon.tech/neondb";
	final String DB_USER = "neondb_owner";
	final String DB_PWD ="npg_K2WJZ1gxRLlc"; 
	final String DB_DRIVER = "org.postgresql.Driver";
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		
		String srno = request.getParameter("srno");
		String sbtn = request.getParameter("sbtn");
		
		String qry = "";
		boolean useParameter = false;
		
		// Fixed null check order
		if( sbtn == null || srno == null || srno.isEmpty() || sbtn.equals("Refresh") )
		{
			qry = "SELECT * FROM STUDENT ORDER BY RNO";
		}
		else if(sbtn.equals("Search"))
		{
			qry = "SELECT * FROM STUDENT WHERE RNO = ?";
			useParameter = true;
		}
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			prestmt = con.prepareStatement(qry);
			
			// Use parameterized query to prevent SQL injection
			if(useParameter)
			{
				prestmt.setInt(1, Integer.parseInt(srno));
			}
			
			rs = prestmt.executeQuery();
			List<Student> L = new ArrayList<>();
			
			while(rs.next())
			{
				L.add(new Student(rs.getInt("rno"), rs.getString("name"), rs.getDouble("per")));
			}
			
			// Redirecting List of Students to view layer
			request.setAttribute("students", L);
			RequestDispatcher rd = request.getRequestDispatcher("./UpdateStudent.jsp");
			rd.forward(request, response);
		}
		catch(NumberFormatException e)
		{
			out.println("Invalid student number format");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			out.println("Database Error: " + e.getMessage());
			e.printStackTrace();
			// Log more details for debugging
			System.err.println("Failed to connect to database: " + e.getClass().getName());
			System.err.println("Message: " + e.getMessage());
		}
		finally
		{
			// Properly close all resources
			try 
			{
				if(rs != null) rs.close();
				if(prestmt != null) prestmt.close();
				if(con != null) con.close();
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
		
		 final String DB_URL ="jdbc:postgresql://ep-misty-sound-a1oah7m7-pooler.ap-southeast-1.aws.neon.tech/neondb";
		 final String DB_USER = "neondb_owner";
		 final String DB_PWD ="npg_K2WJZ1gxRLlc"; 
		 final String DB_DRIVER = "org.postgresql.Driver";
		
		String trno = request.getParameter("trno");
		String tper = request.getParameter("tper");
		String tname = request.getParameter("tname");
		
		// Use parameterized query to prevent SQL injection
		String query = "UPDATE STUDENT SET name = ?, per = ? WHERE rno = ?";
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			prestmt = con.prepareStatement(query);
			
			// Set parameters safely
			prestmt.setString(1, tname);
			prestmt.setDouble(2, Double.parseDouble(tper));
			prestmt.setInt(3, Integer.parseInt(trno));
			
			int rowsAffected = prestmt.executeUpdate();
			
			if(rowsAffected > 0)
			{
				out.println("success");
			}
			else
			{
				out.println("No record found to update");
			}
		}
		catch(NumberFormatException e)
		{
			out.println("Invalid number format");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			out.println("Database Error: " + e.getMessage());
			e.printStackTrace();
			// Log more details for debugging
			System.err.println("Failed to update database: " + e.getClass().getName());
			System.err.println("Message: " + e.getMessage());
		}
		finally
		{
			// Properly close all resources
			try 
			{
				if(prestmt != null) prestmt.close();
				if(con != null) con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
