package com.revature.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.demo.model.Student;
import com.revature.demo.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll(){
		return new ResponseEntity<>(this.studentService.allStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		Student s = this.studentService.getStudentById(id);
		if (s ==null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
		}else {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student){
		
		this.studentService.addStudent(student);
		//ServletUriComponentsBuilder.fromCurrentRequest(); //.path("/{id}").buildAndExpand(this.studentService.getStudentById(id).).toUri();
	}

}
