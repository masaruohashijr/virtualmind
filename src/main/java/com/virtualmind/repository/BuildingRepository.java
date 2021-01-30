package com.virtualmind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Apartment;
import com.virtualmind.domain.Building;

@Component("buildingRepository")
public interface BuildingRepository extends CrudRepository<Building, Integer> {

}
