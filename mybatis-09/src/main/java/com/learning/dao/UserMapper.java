package com.learning.dao;

import com.learning.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User queryUserById(@Param("id") int id);
}
