package com.jxut.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxut.pojo.Student;

import java.util.List;

public interface StudentService {

    public Student getStudentById(Integer id);

    public List<Student> getStudent();

    public boolean updateStudent(Student student);

    public boolean deleteStudentById(Integer id);

    public boolean saveStudent(Student student);

    public Page<Student> getPageStudent(Integer currentPage, Integer sizePage);

    public IPage<Student> getPageStudent(Integer currentPage, Integer sizePage, Student student);
}
