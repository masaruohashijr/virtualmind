package com.virtualmind.dto;

import java.time.LocalDate;

import com.virtualmind.domain.Apartment;

@lombok.Data
public class ApartmentExpenseDTO {

	private Long id;
	private Apartment apartment;
	private String title;
	private Double value;
	private LocalDate factDate;
	private LocalDate dueDate;
	private LocalDate paymentDate;

}
