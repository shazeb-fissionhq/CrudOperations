package com.fission.CrudOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fission.CrudOperation.model.Student;
import com.fission.CrudOperation.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public String addStudents(Student student) {
		studentRepository.save(student);
		return "Created";
	}

	public String updateStudent(Student student, Integer id) {
		Student stu = studentRepository.getById(id);
		if (stu != null) {
			if (student.getStudentName() != null)
				stu.setStudentName(student.getStudentName());
			if (student.getRollNo() != null)
				stu.setRollNo(student.getRollNo());

			if (student.getGender() != null)
				stu.setGender(student.getGender());

			if (student.getAge() != null)
				stu.setAge(student.getAge());
			
			studentRepository.save(stu);

			return "Updated";
		}
		return "Not  Updated";

	}

	public String deleteStudent(Integer id) {
		studentRepository.deleteById(id);
		return "Deleted";
	}

}
