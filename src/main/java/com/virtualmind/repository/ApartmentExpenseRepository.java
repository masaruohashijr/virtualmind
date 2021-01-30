package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.ApartmentExpense;

@Component("apartmentExpenseRepository")
public interface ApartmentExpenseRepository extends CrudRepository<ApartmentExpense, Integer> {

}
