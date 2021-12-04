package com.jxut.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxut.pojo.Student;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DaoTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
     void getStudentById(){
        Student student = studentMapper.selectById(1);
        System.out.println(student);

    }

    @Test
    void getStudents(){
        List<Student> students = studentMapper.selectList(null);
        for (Student student : students) {
            System.out.println(student);

        }

    }

    @Test
    public void getPage(){
        Page<Student> studentPage = new Page<>(2, 5);
        Page<Student> studentPage1 = studentMapper.selectPage(studentPage, null);

        System.out.println(studentPage == studentPage1);
    }


    @Test
    public void testWrapper(){
        String likeGender = "";
        boolean empty = likeGender.isEmpty();
        System.out.println(empty);
        boolean notEmpty = Strings.isNotEmpty(likeGender);
        System.out.println(notEmpty);

        LambdaQueryWrapper<Student> lwarpper = new LambdaQueryWrapper<>();
        lwarpper.like(!likeGender.isEmpty(),Student::getGender,likeGender);
        List<Student> students = studentMapper.selectList(lwarpper);
    }
}
