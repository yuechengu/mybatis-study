import com.learning.dao.TeacherMapper;
import com.learning.pojo.Teacher;
import com.learning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test002(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            System.out.println(sqlSession.getMapper(TeacherMapper.class).getTeacher2(1));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }
}
