package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u2=request.getParameter("username2");
		String p2=request.getParameter("password2");
		String mail=request.getParameter("email");
		String mobile=request.getParameter("phno");
		PrintWriter out=response.getWriter();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ass3","root","root");
			PreparedStatement ps=con.prepareStatement("insert into data(username,password,email,phno) values(?,?,?,?)"); 	
			
			
			ps.setString(1,u2);  
            ps.setString(2,p2);  
            ps.setString(3,mail);  
            ps.setString(4, mobile);
         
            int i = ps.executeUpdate();  
            if(i>0) { 
            out.print("Welcome Developer "+u2);  
            }
            out.close();
    		con.close();
    		ps.close();
		}
		catch(Exception e)
		{
			System.out.println("Error caught in servlet2!!!");
		}
		
	
	}

}
