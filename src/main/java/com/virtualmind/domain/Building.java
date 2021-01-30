package com.virtualmind.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@lombok.Data
@Table(name = "building")
@SequenceGenerator(name = "building_sequence", sequenceName = "seq_building")
public class Building {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_sequence")
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "address", nullable = false, length = 1200)
	private String address;
	
	@OneToMany(mappedBy = "building", targetEntity = BuildingExpense.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<BuildingExpense> expenses = new ArrayList<BuildingExpense>();


}
