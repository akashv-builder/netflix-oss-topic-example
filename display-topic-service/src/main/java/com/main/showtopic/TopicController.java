package com.main.showtopic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	TopicProxy proxy;
	
	@GetMapping("/all-topics")
	public List<Topic> getAllTopic() {
		List<Topic> topiclList = proxy.getAllTopic();
		return topiclList;
	}

}
