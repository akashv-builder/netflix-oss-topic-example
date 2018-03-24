package com.main.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	//need to be taken from db,increment it and again put it in db
	static int id=112;
	
	@Autowired
	TopicRepo rp;

	public List<Topic> getAllTopic() {
		List<Topic> al = new ArrayList<>();
		rp.findAll().forEach(al::add);
		return al;
	}

	public Optional<Topic> getTopic(String id) {
		 Optional<Topic> topic=rp.findById(id);
		 //if not found creating a custom exception and generating the http code
		 
		 //checking if object is null throw exception
		 if(!topic.isPresent()) {
			 throw new TopicNotFountException("id-"+id);
		 }
		 return topic;
	}

	public void addTopic(Topic dl) {
		if(dl.getId()==null) {
			dl.setId("KKD"+id++);
		}
		rp.save(dl);

	}

	public void updateTopic(Topic dl) {
		// dont need an id
		rp.save(dl);

	}

	public void deleteTopic(String id) {
		 Optional<Topic> topic=rp.findById(id);
		 //if not found creating a custom exception and generating the http code
		 
		 //checking if object is null throw exception
		 if(!topic.isPresent()) {
			 throw new TopicNotFountException("id-"+id);
		 }
		rp.deleteById(id);
	}

}
