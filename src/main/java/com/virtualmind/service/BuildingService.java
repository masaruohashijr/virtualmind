package com.virtualmind.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.virtualmind.domain.Apartment;
import com.virtualmind.domain.ApartmentExpense;
import com.virtualmind.domain.Building;
import com.virtualmind.exception.WithoutApartmentsException;
import com.virtualmind.repository.ApartmentExpenseRepository;
import com.virtualmind.repository.ApartmentRepository;
import com.virtualmind.repository.BuildingRepository;

@Component("buildingService")
@Configuration
@ComponentScan("com.virtualmind")
public class BuildingService {

	@Autowired
	ApartmentRepository apartmentRepository;
	@Autowired
	ApartmentExpenseRepository apartmentExpenseRepository;
	@Autowired
	BuildingRepository buildingRepository;

	@Transactional
	public List<ApartmentExpense> registerSharedExpense(Integer buildingId, Double cost)
			throws WithoutApartmentsException {
		List<Apartment> apartments = apartmentRepository.loadApartmentsByBuildingId(buildingId);
		if (apartments.size() == 0) {
			throw new WithoutApartmentsException();
		}
		Double ratedExpense = (double) cost / apartments.size();
		List<ApartmentExpense> registered = new LinkedList<ApartmentExpense>();
		for (Apartment apartment : apartments) {
			ApartmentExpense expense = new ApartmentExpense();
			expense.setValue(ratedExpense);
			expense.setApartment(apartment);
			try {
				apartmentExpenseRepository.save(expense);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return registered;
	}

}
