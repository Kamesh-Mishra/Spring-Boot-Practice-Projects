package com.example.demo;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Laptop;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;


@SpringBootApplication
public class JpaMappingOneToOneApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaMappingOneToOneApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Student student = new Student();
		student.setStudentId(3);
		student.setStudentName("Aastha");
		student.setAbout("I am an Engineer!!");
		
		
		Laptop laptop = new Laptop();
		laptop.setLaptopId(200);
		laptop.setModelNumber("Inspiron");
		laptop.setBrand("Dell");
		laptop.setStudent(student);
		
		student.setLaptop(laptop);
		
		Student save = studentRepository.save(student);
		
		System.out.println("Saved Student  : "+save.getStudentName());
		
//		One TO One Mappings
		
//		Student studentt = studentRepository.findById(3).get();
//		System.out.println("Student Name is : "+studentt.getStudentName());
//		
//		Laptop laptopp = studentt.getLaptop();
//		System.out.println("Laptop Brand is : "+laptopp.getBrand()+" and Model is : "+laptopp.getModelNumber());
//		System.out.println(laptopp.getStudent().getStudentName());
		
		
		
		
	}

}
