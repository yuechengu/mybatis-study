package com.learning.dao;

import com.learning.pojo.User;
import com.learning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }

    @Test
    public void allTest(){

        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //getMapper，执行SQL
            UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);


            mapper.deleteUser(2);

            List<User> userList = mapper.getUsers();
            for (User user : userList) {
                System.out.println(user);
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

}
