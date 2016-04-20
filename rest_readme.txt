rest client request urls for calling backend services: 

GEt:
http://localhost:8080/StudentApp/rest/student/getAllStudents

delete: 
http://localhost:8080/StudentApp/rest/student/removeStudent/1

update:
http://localhost:8080/StudentApp/rest/student/updateStudent/7

header:
content-type
application/json

payload:
{
  "id":"7",
   "name": "sarani",
  "age":"34"
}

Post:
http://localhost:8080/StudentApp/rest/student/addStudent
header: content-type- application/json
payload:

{
"age": "12",
"id": "8",
"name": "dushani"
}



