package com.jxut.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxut.pojo.Result;
import com.jxut.pojo.Student;
import com.jxut.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result getStudents(){
        return new Result(true,studentService.getStudent());
    }

    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable Integer id){
        return new Result(true,studentService.getStudentById(id));
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        return new Result(studentService.updateStudent(student));
    }

    @PostMapping
    public Result saveStudent(@RequestBody Student student){
        return new Result(studentService.saveStudent(student));
    }

    @DeleteMapping("/{id}")
    public Result deleteStudentById(@PathVariable Integer id){
        return new Result(studentService.deleteStudentById(id));
    }

    /*@GetMapping("/{currentPage}/{pageSize}")
    public Result getPageStudent(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Student> page = studentService.getPageStudent(currentPage, pageSize);

        long pages = page.getPages();
        System.out.println(pages);

        if (currentPage > (int) page.getPages()){
            page = studentService.getPageStudent((int) page.getPages(),pageSize);
        }
        return new Result(true,page);
    }*/


    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPageStudent(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Student student){
        IPage<Student> page = studentService.getPageStudent(currentPage, pageSize,student);

        long pages = page.getPages();
        System.out.println(pages);

        if (currentPage > (int) page.getPages()){
            page = studentService.getPageStudent((int) page.getPages(),pageSize,student);
        }
        return new Result(true,page);
    }








}
