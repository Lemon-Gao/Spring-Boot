package com.jxut.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxut.dao.StudentMapper;
import com.jxut.pojo.Student;
import com.jxut.service.StudentService;
import org.apache.ibatis.annotations.Select;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getStudent() {
        return studentMapper.selectList(null);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateById(student) > 0;
    }

    @Override
    public boolean deleteStudentById(Integer id) {
        return studentMapper.deleteById(id) > 0;
    }

    @Override
    public boolean saveStudent(Student student) {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public Page<Student> getPageStudent(Integer currentPage,Integer sizePage) {
        return studentMapper.selectPage(new Page<Student>(currentPage,sizePage),null);
    }

    @Override
    public IPage<Student> getPageStudent(Integer currentPage,Integer sizePage,Student student) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(student.getSname()),Student :: getSname,student.getSname());
        queryWrapper.like(!student.getGender().isEmpty(),Student::getGender,student.getGender());
        Integer tid = student.getTid();
        if (tid!=null){
            queryWrapper.like(Student::getTid,student.getTid());
        }



        Page<Student> studentPage = new Page<>(currentPage, sizePage);

        studentMapper.selectPage(studentPage,queryWrapper);

        return studentPage;
    }


}
