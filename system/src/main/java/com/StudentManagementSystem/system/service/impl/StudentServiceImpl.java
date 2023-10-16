package com.StudentManagementSystem.system.service.impl;

import com.StudentManagementSystem.system.entity.Student;
import com.StudentManagementSystem.system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
      return studentRepository.save(student);
    }

    @Override
    public Student createStudent(Student student) {
        Student student1 = new Student();
        student1.setEmail(student.getEmail());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student1.getLastName());

        return student1;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public  Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

}
