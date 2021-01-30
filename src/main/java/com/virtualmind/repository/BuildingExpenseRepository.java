package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.BuildingExpense;
import com.virtualmind.domain.Topic;

@Component("buildingExpenseRepository")
public interface BuildingExpenseRepository extends CrudRepository<BuildingExpense, Integer> {

}
