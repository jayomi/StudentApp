package com.jayomi.student.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
public class Student {
	
	private String name;
	private int id;
	private int age;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	public Student(String name,int age){
		this.name = name;
		this.age = age;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
