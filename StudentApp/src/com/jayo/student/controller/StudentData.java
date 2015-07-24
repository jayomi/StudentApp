package com.jayo.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jayomi.student.model.Student;
import com.jayomi.student.resources.StudentService;
import com.jayomi.student.resources.StudentServiceImpl;

/**
 * Servlet implementation class StudentData
 */
@WebServlet("/StudentData")
public class StudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher=null;
	String requestType="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();	
		
		if(request.getParameter("delete_St")!=null){
			requestType="delete_St";
		}else if(request.getParameter("addSt")!=null){
			requestType="addSt";
		}else if(request.getParameter("updateSt")!=null){
			requestType="updateSt";
		}else if(request.getParameter("update_St")!=null){
			requestType="update_St";
		}
		
		
		
	/*	requestType=(String) session.getAttribute("addstudent");
		System.out.println("&&&&&&&&&&"+requestType);*/
		
		if(requestType.equalsIgnoreCase("addSt")){
			
			
			int s_id=Integer.parseInt(request.getParameter("stId"));
			String s_name=(String) request.getParameter("stName");
			int s_age=Integer.parseInt(request.getParameter("stAge"));
			
			System.out.println(s_id+"///////"+s_name+"/////////"+s_age);
			
			Student student=new Student();
			student.setId(s_id);
			student.setName(s_name);
			student.setAge(s_age);
			
			request.setAttribute("st_Id", s_id);
			request.setAttribute("st_Name", s_name);
			request.setAttribute("st_Age", s_age);
			
			StudentService studentService=new StudentServiceImpl();
			//String strresponse=studentService.addStudent(student);
			String strresponse=studentService.addStudent(student);
			
			System.out.println("******************"+strresponse);
			//request.setAttribute("addResponse", strresponse);
			
			requestDispatcher=request.getRequestDispatcher("add_Student.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		//requestType=(String) session.getAttribute("deletestudent");
		else if(requestType.equalsIgnoreCase("delete_St")){
			
			int id=Integer.parseInt(request.getParameter("id"));
			StudentService studentService=new StudentServiceImpl();
			studentService.deleteStudent(id);
			requestDispatcher=request.getRequestDispatcher("delete_st.jsp");
			requestDispatcher.forward(request, response);
			
		}else if(requestType.equalsIgnoreCase("updateSt")){
			
			int id=Integer.parseInt(request.getParameter("id"));
			StudentService studentService=new StudentServiceImpl();
			Student st=studentService.getStudent(id);
			String stName=st.getName();
			int stAge=st.getAge();
			request.setAttribute("sId", id);
			request.setAttribute("sName", stName);
			request.setAttribute("sAge", stAge);
			requestDispatcher=request.getRequestDispatcher("update_Student.jsp");
			requestDispatcher.forward(request, response);
			
		}else if(requestType.equalsIgnoreCase("update_St")){
			
			int s_id=Integer.parseInt(request.getParameter("id"));
			String s_name=request.getParameter("name");
			int s_age=Integer.parseInt(request.getParameter("age"));
			Student student=new Student(s_id, s_name, s_age);
			
			StudentService studentService=new StudentServiceImpl();
			studentService.updateStudent(student, s_id);
			System.out.println("updated...................");
			requestDispatcher=request.getRequestDispatcher("welcome.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
