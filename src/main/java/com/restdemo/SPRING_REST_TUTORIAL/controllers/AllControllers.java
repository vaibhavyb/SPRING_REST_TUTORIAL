package com.restdemo.SPRING_REST_TUTORIAL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restdemo.SPRING_REST_TUTORIAL.model.Courses;
import com.restdemo.SPRING_REST_TUTORIAL.services.CourseService;

@RestController
public class AllControllers {
	
	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public List<Courses> getcourses() {
		return courseService.getlist();
	}
	@GetMapping("/courses/{id}")
	public Courses getcourse(@PathVariable int id) {
		return courseService.getcourse_fromlist(id);
	}
	
    @PostMapping("/courses")
	public void addcourse(@RequestBody Courses course) {
    	//InPostman select body ->raw->json new object
    	//Also Click headers->key=content-type and value=application/json
    	courseService.addcourse(course);
    }
    
    @PutMapping("/courses/{id}")
    public void updatecourse(@RequestBody Courses course,@PathVariable int id) {
    	courseService.updatecourse(id,course);
    	
    }
    
    @DeleteMapping("/courses/{id}")
    public void deletecourse(@PathVariable int id) {
    	courseService.deletecourse(id);
    	
    }

}
