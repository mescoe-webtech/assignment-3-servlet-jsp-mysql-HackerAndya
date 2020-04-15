package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u1=request.getParameter("username1");
		String p1=request.getParameter("password1");
		PrintWriter out=response.getWriter();
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ass3","root","root");
			
			Statement stmt= con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from data");
			
			if(rs.next() == false)	//is database empty
	 		{
	 			out.println("Sign Up First");
	 		}else
	 		{
	 			do {
	 				if(u1.equals(rs.getString("USERNAME"))&& p1.equals(rs.getString("PASSWORD")))	//username is present in database
					{
						out.println("Welcome Developer "+u1);
						
					}
					else
					{
						out.println("Login UnSuccessful");
						break;
					}
	 			}while(rs.next());
	 		}
				 
			
            out.close();
		    stmt.close();
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error caught in servlet1!!!");
		}
		
		}
}
