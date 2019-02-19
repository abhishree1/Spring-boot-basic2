package com.emdata.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courserepository;
	public List<Course> getallCourses(String topicId){
			List<Course> course = new ArrayList<>();
			courserepository.findByTopicId(topicId).forEach(course::add);
			return course;
	}
	
	public Course getCourse(String id) {
		 return courserepository.findById(id).orElse(null);
	}
	public void addCourse(Course course) {
		courserepository.save(course);
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courserepository.save(course);
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		courserepository.deleteById(id);
	}
	

	

}
