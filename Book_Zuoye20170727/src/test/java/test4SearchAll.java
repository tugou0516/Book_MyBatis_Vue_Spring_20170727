import org.forten.zuoye.bo.Book2Bo;
import org.forten.zuoye.model.Book2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student1 on 2017/8/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/*.xml" })
public class test4SearchAll {
    @Resource
    private Book2Bo bo;

    @Test
    public void searchAll(){
        List<Book2> list = new ArrayList<>();
        list = bo.queryAll();
        list.forEach(System.out::println);
    }
}
