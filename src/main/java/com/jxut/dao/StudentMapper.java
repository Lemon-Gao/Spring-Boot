package com.jxut.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxut.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {

}
