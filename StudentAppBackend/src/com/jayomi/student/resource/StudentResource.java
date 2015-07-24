package com.jayomi.student.resource;
//====================================================
//						service class
//===================================================

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jayomi.student.model.Student;
import com.jayomi.student.service.StudentServiceImpl;

@Path("/student")
public class StudentResource {
	
	StudentServiceImpl studentService=new StudentServiceImpl();
	List<Student> studentList=studentService.getStudent();
	
	
	@Path("/first")
	public String getMessage(){
		
		String output="hello rest first app";
		//return Response.status(200).entity(output).build();
		System.out.println("student run.......");
		return output;
		
	}
	
	@GET
	@Path("/getStudent/{studentId}")
	//@Path("/getStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("studentId") int studentId){
		
		Student student = null;
		int id = 0;
		String name = null;
		int age = 0;
		for(int i=0;i<studentList.size();i++){
			
			student=studentList.get(i);
			if(student.getId()==studentId){
				
				id=student.getId();
				name=student.getName();
				age=student.getAge();
				break;
				
			}
			
		}		
		System.out.println(">>>>>>>>>>>>>>>> "+id+"\t"+name+"\t"+age);		
		return student;
	}
	
	@GET
	@Path("/getAllStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents(){
		
		return studentList;		
		
	}
	
	@POST
	@Path("/addStudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	//public Response addStudent(@FormParam("id")int id,@FormParam("name")String name,@FormParam("age")int age){
	
	public Response addStudent(Student student){
		
		//Student student=new Student(name,id,age);
		studentService.addStudent(student.getId(),student.getName(),student.getAge());
		//System.out.println("id: "+student.getId()+"name: "+student.getName()+"age: "+student.getAge());
		//System.out.println("inside post()");		
		String result="Track saved";
		return Response.status(201).build();	
		
	}
	
	@DELETE
	@Path("/removeStudent/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeStudent(@PathParam("studentId")int studentId){
		
		String responce=studentService.removeStudent(studentId);
		System.out.println(responce);
		return responce;
		
	}
	
	@PUT
	@Path("/updateStudent/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String UpdateStudent(Student student,@PathParam("studentId") int studentId){
		
		String response=studentService.updateStudent(student,studentId);
		System.out.println(response);
		return response;
		
	}
	
	
	

}
