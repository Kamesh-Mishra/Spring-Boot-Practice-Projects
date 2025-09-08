package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "jpa_student_onetomany")
public class Student {
	
	@Id
	private int studentId;
	
	private String studentName;
	
	private String about;
	
	
	@OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
	private List<Address> addressList;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String about, List<Address> addressList) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.about = about;
		this.addressList = addressList;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String student_Name) {
		this.studentName = student_Name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	
	
	
}
