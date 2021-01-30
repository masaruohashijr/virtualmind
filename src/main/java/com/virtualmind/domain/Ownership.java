package com.virtualmind.domain;

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
@Table(name = "ownership")
@SequenceGenerator(name = "ownership_sequence", sequenceName = "seq_ownership")
public class Ownership {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownership_sequence")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "seq_apartment", referencedColumnName = "id", nullable = false)
	private Apartment apartment;

	@ManyToOne(optional = false)
	@JoinColumn(name = "seq_owner", referencedColumnName = "id", nullable = false)
	private Owner owner;

}
