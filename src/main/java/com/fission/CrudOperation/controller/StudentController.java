package com.fission.CrudOperation.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.fission.CrudOperation.model.Student;
import com.fission.CrudOperation.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudents(student));
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(student, id));
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> DeleteStudent(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.deleteStudent(id));
	}

}
