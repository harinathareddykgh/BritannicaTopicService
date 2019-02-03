package com.britannica.topicservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.britannica.topicservice.model.TopicBean;
import com.britannica.topicservice.service.TopicService;

@RestController
@RequestMapping(value = "/eb")
public class TopicRestController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping(path = "/topicservicestatus")
    public String topicServiceStatus() { 
        return "Its' up and Running!!!";
    }

	@GetMapping(path = "/topic/{id}")
    public TopicBean getTopicById(@PathVariable Integer id) {
		return topicService.retriveTopicDetails(id);	
    }

	@GetMapping(path = "/class/{className}")
    public List<Integer> getTopicByClassName(@PathVariable String className) {      
		return topicService.retriveTopicDetailsByClassName(className);	
    }

	@GetMapping(path = "/all/topic")
    public List<TopicBean> geAllTopics() {      		
		return topicService.retriveAllTopics();	
    }
}
