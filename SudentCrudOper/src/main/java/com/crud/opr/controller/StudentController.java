package com.crud.opr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.opr.entities.Student;
import com.crud.opr.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//build create student rest api
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	//build get all student rest api
	@GetMapping()
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	//build find by id rest api
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int rollNo) {
		return new ResponseEntity<Student>(studentService.getStudentById(rollNo), HttpStatus.OK);
	}
	
	//build api of update student
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int rollNo, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, rollNo),HttpStatus.OK);
	}
	
	//build api for delete student
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int rollNo){
		studentService.deleteStudent(rollNo);
		return new ResponseEntity<String>("Student deleted Successfully !!!!",HttpStatus.OK);
		
	}
}
