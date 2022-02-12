package com.samsung.samsung.tugas.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private Integer price;

	@Column(name = "created_at", nullable = false)
	private Timestamp created_at;

	public Books() {
	}

	public Books(String name, String author, Integer price, Timestamp created_at) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.created_at = created_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", created_at="
				+ created_at + "]";
	}

}
