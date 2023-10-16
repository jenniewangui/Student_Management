package com.StudentManagementSystem.system;

import com.StudentManagementSystem.system.entity.Student;
import com.StudentManagementSystem.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		Student student1 = new Student(1l, "Jeniffer", "Kibe", "jenkibe@gmail.com");
		studentRepository.save(student1);

		Student student2 = new Student(2l, "Bianca", "Chalie", "bee@gmail.com");
		studentRepository.save(student2);

		Student student3 = new Student(3l, "Victor", "Maxy", "victormax@gmail.com");
		studentRepository.save(student3);
	}
}
