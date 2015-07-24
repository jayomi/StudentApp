package com.jayo.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**l
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RequestDispatcher requestDispatcher=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();		
		String username=request.getParameter("userName");
		String passwd=request.getParameter("passwd");
		
		//out.print(username);
		if((username.equalsIgnoreCase("jayo"))&passwd.equals("123")){ 
			
			requestDispatcher=request.getRequestDispatcher("welcome.jsp");
			requestDispatcher.forward(request, response);
		}
		else{
			requestDispatcher=request.getRequestDispatcher("errorLogin.jsp");
			requestDispatcher.forward(request, response);
		}
		//out.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
