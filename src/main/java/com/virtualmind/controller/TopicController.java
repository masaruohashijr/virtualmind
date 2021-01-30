package com.virtualmind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtualmind.domain.Topic;
import com.virtualmind.dto.TopicDTO;
import com.virtualmind.json.Response;
import com.virtualmind.service.TopicService;

@RestController
@RequestMapping("/api/topic/v1")
@Configuration
@ComponentScan("com.virtuamind")
public class TopicController {
	@Autowired
	TopicService topicService;
	
	@RequestMapping(value = "/update", method =  RequestMethod.PUT)
	public ResponseEntity<Response> update(String id, String name)	{
		Response response = new Response();
		try {
			TopicDTO topicDTO = new TopicDTO();
			long idt = Long.parseLong(id);
			topicDTO.setId(idt);
			topicDTO.setName(name);
			Topic updatedTopic = topicService.updateTopic(idt, topicDTO);
			response.setReturnObject(updatedTopic);
			response.setReturnMessages("Successfully updated!!!");
		} catch (Exception e) {
			response.setReturnMessages(e.getMessage());	
		}
		return ResponseEntity.ok(response);
	}
}
