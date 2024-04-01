package com.model;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
	private int id;
	private String first_name;
	private String last_name;
	private LocalDate date;
	public Customer(int id, String first_name, String last_name, LocalDate date) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date = date;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", date=" + date
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, first_name, id, last_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(date, other.date) && Objects.equals(first_name, other.first_name) && id == other.id
				&& Objects.equals(last_name, other.last_name);
	}
	
	
	

}
