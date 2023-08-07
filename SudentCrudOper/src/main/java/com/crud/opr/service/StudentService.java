package com.crud.opr.service;

import java.util.List;

import com.crud.opr.entities.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int rollNo);
	Student updateStudent(Student student, int rollNo);
	void deleteStudent(int rollNo);
}
