package com.StudentManagementSystem.system.service.impl;

import com.StudentManagementSystem.system.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student saveStudent(Student student);
    Student createStudent(Student student);

    Student getStudentById(Long Id);

    Student updateStudent(Student student);
}
