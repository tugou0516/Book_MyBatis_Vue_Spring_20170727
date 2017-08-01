package org.forten.zuoye.action;

import org.forten.zuoye.dto.Message;
import org.forten.zuoye.model.Book2;
import org.forten.zuoye.bo.Book2Bo;
import org.forten.zuoye.qo.Book2NameAndPriceQo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/book")
public class Book2Action {
    @Resource
    private Book2Bo bo;

    @RequestMapping("save")
    public @ResponseBody
    Message saveBook(@RequestBody Book2 book) {
        int i = bo.doSave(book);
        return new Message("成功添加" + i + "条数据。");
    }

    @RequestMapping("selectAll")
    public String selectAll() {
        List<Book2> list = bo.queryAll();
        System.out.println(list);
        return "bookList.html";
    }

    @RequestMapping("selectById")
    public @ResponseBody Book2 selectById(@RequestBody int id){
        return bo.queryById(id);
    }

    @RequestMapping("selectNamePrice")
    public @ResponseBody
    List<Book2> selectNamePrice(@RequestBody Book2NameAndPriceQo qo) {
        List<Book2> list = bo.queryByNameAndPrice(qo);
        return list;
    }

    @RequestMapping("deleteBooks")
    public @ResponseBody
    int deleteBooks(@RequestBody int[] ids) {
        int i = 0;
        try {
            for (i = 0; i < ids.length; i++) {
                bo.deleteById(ids[i]);
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @RequestMapping("updateBook")
    public @ResponseBody int updateBook(@RequestBody Book2 book){
        return bo.updateBook(book);
    }
}
