package com.jayomi.student.resources;

import java.util.List;
import java.util.Map;

import com.jayomi.student.model.Student;

public interface StudentService {

	public abstract List<Student> getStudents();
	
	public abstract Student getStudent(int id);
	
	public abstract String addStudent(Student student);
	
	public abstract void deleteStudent(int sid);
	
	public abstract void updateStudent(Student student,int id);

}