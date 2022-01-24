package com.learning.dao;

import com.learning.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeacher1();

    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacher2(@Param("tid") int id);


}
