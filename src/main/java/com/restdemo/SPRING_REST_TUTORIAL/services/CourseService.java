package com.restdemo.SPRING_REST_TUTORIAL.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restdemo.SPRING_REST_TUTORIAL.model.Courses;

@Service
public class CourseService {
	
	Courses c1=new Courses(1,"Life is Beautiful","A.K Abdul");
	Courses c2=new Courses(2,"Rangitharanga","Bishma");
	Courses c3=new Courses(3,"She is happy","Rekha gundumani");
	
	List<Courses> courses=new ArrayList<>(Arrays.asList(c1,c2,c3));
	
	public List<Courses> getlist(){
		return courses;
	}

	public Courses getcourse_fromlist(int id) {
		return courses.stream().filter(t->t.getId()==id).findFirst().get();

	}

	public void addcourse(Courses course) {
	courses.add(course);	
	}

	public void updatecourse(int id, Courses course) {
		for(int i=0;i<courses.size();i++) {
			Courses c=courses.get(i);
			if(c.getId()==id) {
				courses.set(i, course);//UPDATING
				return;
			}
		}
		
	}

	public void deletecourse(int id) {
		for(int i=0;i<courses.size();i++) {
			Courses c=courses.get(i);
			if(c.getId()==id) {
				courses.remove(c);//REMOVING
				return;
			}
		}
		
	}
	

}
