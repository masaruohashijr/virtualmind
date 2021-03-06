package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Topic;

@Component("topicRepository")
public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
