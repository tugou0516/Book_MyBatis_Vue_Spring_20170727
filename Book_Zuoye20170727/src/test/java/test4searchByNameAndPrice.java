import org.forten.zuoye.model.Book2;
import org.forten.zuoye.bo.Book2Bo;
import org.forten.zuoye.qo.Book2NameAndPriceQo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student1 on 2017/7/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/*.xml" })
public class test4searchByNameAndPrice {
    @Resource
    private Book2Bo bo;

    @Test
    public void testSearchNameAndPrice(){
        Book2NameAndPriceQo qo = new Book2NameAndPriceQo("为什么",20,50);
        List<Book2> list = new ArrayList<>();
        list = bo.queryByNameAndPrice(qo);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
