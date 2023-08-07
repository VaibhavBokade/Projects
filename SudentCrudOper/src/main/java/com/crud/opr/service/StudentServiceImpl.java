package com.crud.opr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.opr.entities.Student;
import com.crud.opr.exception.ResourceNotFoundException;
import com.crud.opr.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int rollNo) {
		Optional<Student> student= studentRepository.findById(rollNo);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new ResourceNotFoundException("student","Id",rollNo);
		}
	
	}

	@Override
	public Student updateStudent(Student student, int rollNo) {
		Student existingStudent = studentRepository.findById(rollNo).orElseThrow(()-> new ResourceNotFoundException("student", "Id", rollNo));
		existingStudent.setName(student.getName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentRepository.save(existingStudent);
		
		return existingStudent;
	}

	@Override
	public void deleteStudent(int rollNo) {
		studentRepository.findById(rollNo).orElseThrow(()-> new ResourceNotFoundException("student", "id", rollNo));
		studentRepository.deleteById(rollNo);;
	}

}
