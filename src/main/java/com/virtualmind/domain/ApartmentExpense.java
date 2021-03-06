package com.virtualmind.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@lombok.Data
@Table(name = "apartment_expense")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "apartment_expense_sequence", sequenceName = "seq_apartment_expense")
public class ApartmentExpense {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_expense_sequence")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_apartment", referencedColumnName = "id", nullable = false)
	private Apartment apartment;

	@Column(name = "title")
	private String title;

	@Column(name = "address")
	private Double value;

	@Column(name = "fact_date")
	private LocalDate factDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "pmt_date")
	private LocalDate paymentDate;

}
