package com.learning.dao;

import com.learning.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper2 {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前必须加上@Param("id")注解
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);

}
