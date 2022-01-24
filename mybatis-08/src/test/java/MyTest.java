import com.learning.dao.BlogMapper;
import com.learning.pojo.Blog;
import com.learning.utils.IDutils;
import com.learning.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MyTest {
    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.add(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.add(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.add(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.add(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIFTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map map = new HashMap();
//        map.put("title","Java如此简单");
        map.put("author","说");
//        map.put("views","9999");
//        map.put("id","1ff68cd5d8f645e69ae094a1d3e70ed6");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }



        sqlSession.close();
    }

    @Test
    public void queryBlogForEachTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(2);
        ids.add(4);



        Map map = new HashMap();
        map.put("ids", ids);

        mapper.queryBlogForEach(map);

        sqlSession.close();
    }

    //特殊字符hash
    @SuppressWarnings("all")
    @Test
    public void hashTest(){
        String testStr = "及ë‰";
        int hashCode1 = testStr.hashCode();

        char[] testStrArray = {'及', 'ë', '‰'};
        int h = 0;
            char val[] = testStrArray;
            for (int i = 0; i < testStrArray.length; i++) {
                h = 31 * h + val[i];
            }
        int hashCode2 = h;

        assertEquals(hashCode1,hashCode2);
    }


}
