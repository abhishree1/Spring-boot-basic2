package com.emdata.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicrepository;
	public List<Topic> getallTopics(){
			List<Topic> topics = new ArrayList<>();
			topicrepository.findAll().forEach(topics::add);
			return topics;
	}
	
	public Topic getTopic(String id) {
		 return topicrepository.findById(id).orElse(null);
	}
	public void addTopic(Topic topic) {
		topicrepository.save(topic);
	}

	public void updateTopic(String id,Topic topic) {
		// TODO Auto-generated method stub
		topicrepository.save(topic);
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		topicrepository.deleteById(id);
	}
	

	

}
