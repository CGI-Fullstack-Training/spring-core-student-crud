package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student1")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "entering_date")
	private String date;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "code")
	private String code;

	public Student() {
		super();
	}

	public Student(String name, String date, String nationality, String code) {
		super();
		this.name = name;
		this.date = date;
		this.nationality = nationality;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", date=" + date + ", nationality=" + nationality + ", code="
				+ code + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}