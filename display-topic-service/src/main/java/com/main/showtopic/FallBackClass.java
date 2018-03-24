package com.main.showtopic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class FallBackClass implements TopicProxy {

	@Override
	public List<Topic> getAllTopic() {
		return Arrays.asList(new Topic("default", "default", "default", "default"));
	}

	@Override
	public Topic getTopic(String id) {
		Topic topic = new Topic("dummy", "dummy", "dummy", "dummy");
		return topic;
	}

}
