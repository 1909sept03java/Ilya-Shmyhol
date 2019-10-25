package com.revature.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.demo.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	//public List<Course> getByFirstName(Student s);

}
