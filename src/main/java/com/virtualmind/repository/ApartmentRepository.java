package com.virtualmind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.virtualmind.domain.Apartment;

@Component("apartmentRepository")
public interface ApartmentRepository extends CrudRepository<Apartment, Integer> {
	
	@Query("SELECT a FROM Apartment a WHERE a.building.id = ?")
	List<Apartment> loadApartmentsByBuildingId(Integer buildingId);

}
