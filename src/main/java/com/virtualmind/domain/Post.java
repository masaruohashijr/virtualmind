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
@Table(name = "post")
@SequenceGenerator(name = "post_sequence", sequenceName = "seq_post")
public class Post {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
	private Long id;

	@Column(name = "title", nullable = false, length = 16536)
	private String title;

	@Column(name = "text", nullable = false, length = 16536)
	private String text;

}
