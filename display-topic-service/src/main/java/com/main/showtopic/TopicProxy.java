package com.main.showtopic;

import java.util.List;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.showtopic.Topic;

//@FeignClient(value="topic-service",url="localhost:8000")
//@FeignClient(value="topic-service")
@FeignClient(value="api-gateway-zull",fallback= FallBackClass.class)
@RibbonClient(name="topic-service")
public interface TopicProxy {

	@GetMapping(value="topic-service/topic",produces = "application/json")
	public List<Topic> getAllTopic();
	
	@GetMapping("topic-service/topic/{id}")
	public Topic getTopic(@PathVariable(value = "id") String id);
}
