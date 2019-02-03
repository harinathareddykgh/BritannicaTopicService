package com.britannica.topicservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.britannica.topicservice.dao.TopicRepository;
import com.britannica.topicservice.model.TopicBean;

@Service
public class TopicService {

	@Autowired
    TopicRepository topicRepository;
	
	public TopicBean retriveTopicDetails(Integer topicId) {
		//System.out.println("Id " +topicId);
		TopicBean topic;
			Optional<TopicBean> optional = topicRepository.findById(topicId);
			if (optional.isPresent() ) {
				topic = optional.get();
				//System.out.println("Bean " +topic.toString());
				return topic;
			}	
		else {
			topic = new TopicBean();
			topic.setTopicId(topicId);
			topic.setUrlTitle("URL Not Found");
			topic.setUrlClass("topic "+topicId+" not in database");
			return topic;
		}	
	}
			public List<Integer> retriveTopicDetailsByClassName(String name) {
				//System.out.println("Id " +topicId);
				List<Integer> topicIdList = new ArrayList<Integer>();
					Iterable<TopicBean> topics = topicRepository.findAll();
					
					topics.forEach(tpc->{
						if(tpc.getUrlClass().equals(name)){
							topicIdList.add(tpc.getTopicId());
						}
					});

				return topicIdList;					
	}
			public List<TopicBean> retriveAllTopics() {
				//System.out.println("Id " +topicId);
				List<TopicBean> topicList = new ArrayList<TopicBean>();
					Iterable<TopicBean> topics = topicRepository.findAll();
					
					topics.forEach(tpc->{						
							topicList.add(tpc);					
					});

				return topicList;					
	}
		/*	public List<TopicBean> retriveTopicDetailsByClassName(String name) {
				//System.out.println("Id " +topicId);
				List<TopicBean> topicList = new ArrayList<TopicBean>();
					Iterable<TopicBean> topics = topicRepository.findAll();
					
					topics.forEach(tpc->{
						if(tpc.getUrlClass().equals(name)){
							topicList.add(tpc);
						}
					});

				return topicList;	*/
}
