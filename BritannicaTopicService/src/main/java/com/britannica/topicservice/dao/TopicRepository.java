package com.britannica.topicservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.britannica.topicservice.model.TopicBean;

public interface TopicRepository extends CrudRepository<TopicBean, Integer>  {

}
