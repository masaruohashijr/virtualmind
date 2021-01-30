package com.virtualmind.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Apartment;
import com.virtualmind.domain.Topic;

@Component("apartmentRepository")
public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {

}
