package com.StudentManagementSystem.system.controller;

import com.StudentManagementSystem.system.entity.Student;
import com.StudentManagementSystem.system.repository.StudentRepository;
import com.StudentManagementSystem.system.service.impl.StudentService;
import com.StudentManagementSystem.system.service.impl.StudentServiceImpl;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public abstract class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    // handler method to return list student and return mode and view
    @GetMapping("/students")
    public String ListStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("Student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("Student") Student student,
                                Model mode) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
}
