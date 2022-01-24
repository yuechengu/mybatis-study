import com.learning.dao.UserMapper;
import com.learning.pojo.User;
import com.learning.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {


    @Test
    public void test001(){
        SqlSession sqlSession =
                MybatisUtils.getSqlSession();
        SqlSession sqlSession2 =
                MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(5);
        System.out.println(user);

        sqlSession.close();

        System.out.println("========================================");
        User user2 = mapper2.queryUserById(5);
        System.out.println(user2);

        System.out.println("========================================");
        System.out.println(user==user2);



        sqlSession2.close();
    }
}
