package com.jayomi.student.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.jayomi.student.model.Student;

public class StudentServiceImpl implements StudentService {

	List<Student> studentsList=new ArrayList<Student>();
	public StudentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Student> getStudents(){		
		
		try {
			
				String resturl="http://localhost:8080/StudentAppBackend/rest/student/getAllStudents";
				HttpClient httpClient=new DefaultHttpClient();
				HttpGet httpGet=new HttpGet(resturl);
				HttpResponse httpResponse=httpClient.execute(httpGet);
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
				String strResponse=bufferedReader.readLine();
				
				System.out.println("..........."+strResponse);
				JSONObject jsonObject=new JSONObject(strResponse);
				
				//student is a root element
				
				for (int i = 0; i < jsonObject.getJSONArray("student").length(); i++) {
					
					JSONObject jobObject=new JSONObject();
					jobObject.put("student", jsonObject.getJSONArray("student").get(i));
					
					int id=jobObject.getJSONObject("student").getInt("id");
					String name=jobObject.getJSONObject("student").getString("name");
					int age=jobObject.getJSONObject("student").getInt("age");
					Student tempStudent=new Student(id, name, age);
					studentsList.add(tempStudent);
				}
				
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			return studentsList;
		}
	}
	
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		Student student = null;
		try {
			
				String resturl="http://localhost:8080/StudentAppBackend/rest/student/getStudent/"+String.valueOf(id);
				HttpClient httpClient=new DefaultHttpClient();
				HttpGet httpGet=new HttpGet(resturl);
				HttpResponse httpResponse=httpClient.execute(httpGet);				
				BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
				String strResponse=bufferedReader.readLine();
				JSONObject jsonObject=new JSONObject(strResponse);
				int s_id=jsonObject.getInt("id");
				String s_name=jsonObject.getString("name");
				int s_age=jsonObject.getInt("age");
				student=new Student(s_id, s_name, s_age);
				
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			return student;
		}
		
	}
		
	@Override
	public String addStudent(Student student) {
		
		String strResponse="";
		StringBuilder response=new StringBuilder();
		try {
			
			String restUrl="http://localhost:8080/StudentAppBackend/rest/student/addStudent";			
			HttpClient httpClient=new DefaultHttpClient();
			HttpPost httpPost=new HttpPost(restUrl);
			httpPost.setHeader("Content-Type","application/json");
			
			System.out.println(student.getAge()+"..........."+student.getId()+"........."+student.getName());
			
			//String payload="{student: {age: "+student.getAge()+","+"id : "+student.getId()+","+"name: "+student.getName()+"}}";
			

			String payload="{\"id\" : \""+student.getId()+"\","+"\"name\" : \""+student.getName()+"\","+"\"age\" : \""+student.getAge()+"\"}";
			
			httpPost.setEntity(new StringEntity(payload,ContentType.create("application/json")));
			HttpResponse httpResponse=httpClient.execute(httpPost);
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("htttpresponse:"+httpResponse);			
			System.out.println("readddd: "+httpResponse.getEntity().getContent());
			
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			//strResponse=bufferedReader.readLine();				
			
			
			while((strResponse=bufferedReader.readLine())!=null){
				
				response.append(strResponse+"\n");	
				/*
				 //parse our JSON response
				JSONParser jsonParser=new JSONParser();
				JSONObject jsonObject= (JSONObject) jsonParser.parse(line);
				response=(Map) jsonObject.getJSONArray("student");*/
				System.out.println("from post: "+response);
			}
			
			bufferedReader.close();
			
			System.out.println("from post:"+response.toString());
			//return strResponse;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//return response;
			return response.toString();
		}
	}

	@Override
	public void deleteStudent(int sid) {
		// TODO Auto-generated method stub
		try {
			
			String s_id=String.valueOf(sid);
			String restUrl="http://localhost:8080/StudentAppBackend/rest/student/removeStudent/"+s_id;
			HttpClient httpClient=new DefaultHttpClient();
			HttpDelete httpDelete=new HttpDelete(restUrl);
			HttpResponse httpResponse=httpClient.execute(httpDelete);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		try {
			
			String resturl="http://localhost:8080/StudentAppBackend/rest/student/updateStudent/"+String.valueOf(id);
			HttpClient httpClient=new DefaultHttpClient();
			HttpPut httpPut=new HttpPut(resturl);
			httpPut.setHeader("Content-Type","application/json");
			String payload="{\"id\" : \""+student.getId()+"\","+"\"name\" : \""+student.getName()+"\","+"\"age\" : \""+student.getAge()+"\"}";
			httpPut.setEntity(new StringEntity(payload,ContentType.create("application/json")));
			HttpResponse httpResponse=httpClient.execute(httpPut);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	
}
