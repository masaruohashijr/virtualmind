package com.virtualmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.virtualmind.domain.Topic;
import com.virtualmind.dto.TopicDTO;
import com.virtualmind.repository.TopicRepository;

public class BillingDocumentService {

	public void issueDocument(Long topicId, TopicDTO topicDTO) {
	}

}
