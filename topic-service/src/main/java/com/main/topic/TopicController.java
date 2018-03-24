package com.main.topic;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TopicController {

	@Autowired
	TopicService topic;

	@Autowired
	private MessageSource messageSource; 
	
	@GetMapping("/topic")
	@HystrixCommand(fallbackMethod="ifGetTopicFails")
	public List<Topic> getAllTopic() {
		return topic.getAllTopic();
	}
	
	public List<Topic> ifGetTopicFails(){		
		return Arrays.asList(new Topic("default", "default", "default"));		
	}

	@GetMapping("/topic/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topic.getTopic(id);
	}

	@PostMapping
	//adding validation using @valid
	public ResponseEntity<Object> addTopic(@Valid @RequestBody Topic dl) {
		topic.addTopic(dl);
		//this is added to give a response that the uri that is going to be created is successfully created
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dl.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public String updateTopic(@RequestBody Topic dl) {
		topic.updateTopic(dl);
		return "topic updated";
	}

	@DeleteMapping("/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		topic.deleteTopic(id);
	}
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}
		

}
