package com.jayomi.student.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jayomi.student.model.Student;
import com.jayomi.student.resource.DBService;
import com.jayomi.student.utils.HibernateUtilities;

public class StudentServiceImpl {
	
	DBService dbservice=new DBService();
	Connection conn = null;
	Statement stmt=null;
	
	
	public List<Student> getStudent(){		
					
			List<Student> studentList=new ArrayList<Student>();
			try {
				
				conn=dbservice.setConnection();
				stmt=conn.createStatement();
				String query="select * from student";
				ResultSet rs=stmt.executeQuery(query);
				
				
				while(rs.next()){
					
					int id=rs.getInt("id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					Student student=new Student(name,id,age);
					studentList.add(student);										
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return studentList;				
		
	}
	
	public Student addStudent(int id,String name,int age){		
		
		Student student=new Student(name,age);		
		try {			
			
			System.out.println("inside student service.....");
			System.out.println(id+".........."+name+"........"+age);
			conn=dbservice.setConnection();
			stmt=conn.createStatement();			
			student.setId(id);
			student.setName(name);
			student.setAge(age);		
			String query="INSERT INTO student(id,name,age) VALUES ('"+id+"','"+name+"','"+age+"'+'"+"')";
			
			//stmt.executeUpdate(query);
			stmt.execute(query);
			/*while(rs.next()){
				student.setId(id);
				student.setName(name);
				student.setAge(age);				
			}*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;			
	}
	
	public String removeStudent(int s_id){
		
		String response="";		
		try {
			
			conn=dbservice.setConnection();
			stmt=conn.createStatement();
			//String query="delete from student where id in (select id from student where id="+s_id+")";
			String query2="delete from student where id="+s_id;

			//String qu="delete from student where id=101";
			stmt.execute(query2);
			response="Successfully deleted..";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response="Faild to delete";
			e.printStackTrace();			
		}	
		return response;		
	}
	
	public String updateStudent(Student student,int id){	
		
		String updatestmt="";		
		
		try {
			
			//add a column
			conn=dbservice.setConnection();
			stmt=conn.createStatement();
			/*String addcolumn="ALTER TABLE student add city VARCHAR(50) NOT NULL";
			stmt.execute(addcolumn);
			updatestmt="Successfully added colomn";*/
			
			/*String st="SELECT * FROM student where id="+id;
			ResultSet reset=stmt.executeQuery(st);
			if(reset.next()){
				String update_query="UPDATE student SET name= "+student.getName()+", age="+student.getAge();
				stmt.execute(update_query);
				updatestmt="Successfully Updated student";
			}*/
			
			System.out.println(student.getName()+student.getAge());
			String update_query="UPDATE student SET name='"+student.getName()+"',age='"+student.getAge()+"' WHERE id='"+id+"' ";
			stmt.execute(update_query);
			updatestmt="Successfully Updated student";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatestmt;
		
	}
}
