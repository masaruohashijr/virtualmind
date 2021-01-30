package com.virtualmind.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@lombok.Data
@Table(name = "owner")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "owner_sequence", sequenceName = "seq_owner")
public class Owner {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_sequence")
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

}
