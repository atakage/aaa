package com.biz.student.domain;

public class StudentDTO {
	
	
	private String st_num;
	private String st_name;
	private String st_dept;
	private int int_grade;
	private String st_tel;
	
	
	public StudentDTO(String st_num, String st_name, String st_dept, int int_grade, String st_tel) {
		super();
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_dept = st_dept;
		this.int_grade = int_grade;
		this.st_tel = st_tel;
	}
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSt_num() {
		return st_num;
	}
	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_dept() {
		return st_dept;
	}
	public void setSt_dept(String st_dept) {
		this.st_dept = st_dept;
	}
	public int getInt_grade() {
		return int_grade;
	}
	public void setInt_grade(int int_grade) {
		this.int_grade = int_grade;
	}
	public String getSt_tel() {
		return st_tel;
	}
	public void setSt_tel(String st_tel) {
		this.st_tel = st_tel;
	}

	@Override
	public String toString() {
		return "StudentDTO [st_num=" + st_num + ", st_name=" + st_name + ", st_dept=" + st_dept + ", int_grade="
				+ int_grade + ", st_tel=" + st_tel + "]";
	}

	
	
}
