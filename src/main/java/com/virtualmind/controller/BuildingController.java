package com.virtualmind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualmind.domain.ApartmentExpense;
import com.virtualmind.domain.Topic;
import com.virtualmind.dto.TopicDTO;
import com.virtualmind.json.Response;
import com.virtualmind.service.BuildingService;
import com.virtualmind.service.TopicService;

@RestController
@RequestMapping("/api/topic/v1")
@Configuration
@ComponentScan("com.virtuamind")
public class BuildingController {
	
	@Autowired
	BuildingService buildingService;
	
	@RequestMapping(value = "/registerSharedExpense", method =  RequestMethod.POST)
	public ResponseEntity<Response> registerSharedExpense(@RequestParam String id, @RequestParam String cost){
		Response response = new Response();
		try {
			Integer idt = Integer.parseInt(id);
			Double costValue = Double.valueOf(cost);
			List<ApartmentExpense> registerSharedExpenses = buildingService.registerSharedExpense(idt, costValue);
			response.setReturnObject(registerSharedExpenses);
			response.setReturnMessages("Successfully updated!!!");
		} catch (Exception e) {
			response.setReturnMessages(e.getMessage());	
		}
		return ResponseEntity.ok(response);
	}
}
