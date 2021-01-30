package com.virtualmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.virtualmind.domain.Topic;
import com.virtualmind.dto.TopicDTO;
import com.virtualmind.repository.TopicRepository;

@Component("topicService")
@Configuration
@ComponentScan("com.virtualmind")
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	@Transactional
	public Topic updateTopic(Long topicId, TopicDTO topicDTO) {
		Topic topic = new Topic();
		topic.setId(topicDTO.getId());
		topic.setName(topicDTO.getName());
		Topic saved = topicRepository.save(topic);
		return saved;
	}

}
