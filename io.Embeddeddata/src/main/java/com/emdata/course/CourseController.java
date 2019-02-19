package com.emdata.course;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emdata.topics.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topic/{topicId}/course")
	public List<Course> listOfTopic(@PathVariable String topicId){
		return courseService.getallCourses(topicId);
	}
	
	@RequestMapping("/topic/{topicId}/course/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topic/{topicId}/course/{id}")
	public void addTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topic/{topicId}/course/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topic/{topicId}/course/{id}")
	public void updateTopic(@PathVariable String id) {
			courseService.deleteCourse(id);
	}
	
	


}

