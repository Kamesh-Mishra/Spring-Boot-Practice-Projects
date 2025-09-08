package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Address;
import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class JpaMappingOneToManyApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpaMappingOneToManyApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("Aastha");
		student.setAbout("I am an Engineer!!");
		
		Address address = new Address();
		address.setAddressId(1);
		address.setStreet("sector-8");
		address.setCity("Jaipur");
		address.setCountry("India");
		address.setStudent(student);
		
		Address address2 = new Address();
		address2.setAddressId(2);
		address2.setStreet("Cyber City");
		address2.setCity("Gurugram");
		address2.setCountry("India");
		address2.setStudent(student);
		
		ArrayList<Address> addressList = new ArrayList<>();
		addressList.add(address);
		addressList.add(address2);
		
		student.setAddressList(addressList);

		
		Student save = studentRepository.save(student);
		
		System.out.println("Saved Student  : "+save.getStudentName());
	
		
	}
}