package com.akash.entities;

public class Student 
{
	private Integer rno;
	private String name;
	private Double per;
	
	public Student() {}
	
	public Student(Integer rno, String name, Double per) {
		super();
		this.rno = rno;
		this.name = name;
		this.per = per;
	}

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", per=" + per + "]";
	}
	
	
}
