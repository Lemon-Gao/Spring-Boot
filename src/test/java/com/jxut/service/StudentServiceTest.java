package com.jxut.service;

import com.jxut.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void getStudentById() {

        Student studentById = studentService.getStudentById(1);

        System.out.println(studentById);

    }

    @Test
    void getStudent() {

        List<Student> student = studentService.getStudent();

        for (Student student1 : student) {
            System.out.println(student1);

        }
    }

    @Test
    void updateStudent() {
        Student studentById = studentService.getStudentById(7);

        studentById.setAge(38);
        boolean b = studentService.updateStudent(studentById);

        System.out.println(b);
    }

    @Test
    void deleteStudentById() {
        studentService.deleteStudentById(7);
    }

    @Test
    void saveStudent() {

        Student student = new Student(7, "钟无艳", "女", 38, 2);

        studentService.saveStudent(student);
        studentService.getStudent();
    }

    @Test
    void getPageStudent() {
        studentService.getStudent();
        studentService.getPageStudent(1,3);
        studentService.getPageStudent(2,3);
        studentService.getPageStudent(3,3);

    }
}