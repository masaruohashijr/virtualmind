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

@Entity
@lombok.Data
@Table(name = "apartment")
@SequenceGenerator(name = "apartment_sequence", sequenceName = "seq_apartment")
public class Apartment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_sequence")
	private Long id;

	@Column(name = "room", nullable = false, length = 10)
	private String roomNumber;

	@OneToMany(mappedBy = "apartment", targetEntity = ApartmentExpense.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<ApartmentExpense> expenses = new ArrayList<ApartmentExpense>();

}
