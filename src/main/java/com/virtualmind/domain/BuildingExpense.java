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

import lombok.Data;

@Entity
@lombok.Data
@Table(name = "building")
@SequenceGenerator(name = "building_sequence", sequenceName = "seq_building")
public class BuildingExpense {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_sequence")
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "seq_building", referencedColumnName = "id", nullable = false)
	private Building building;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "address", nullable = false)
	private Double value;

	@Column(name = "fact_date")
	private LocalDate factDate;
	
	@Column(name = "due_date", nullable = false)
	private LocalDate dueDate;
	
	@Column(name = "pmt_date", nullable = false)
	private LocalDate paymentDate;

}
