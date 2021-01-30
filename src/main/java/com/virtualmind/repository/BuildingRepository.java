package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Building;
import com.virtualmind.domain.Topic;

@Component("buildingRepository")
public interface BuildingRepository extends CrudRepository<Building, Integer> {

}
