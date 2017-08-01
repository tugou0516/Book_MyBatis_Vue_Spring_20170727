package org.forten.zuoye.bo;

import org.forten.zuoye.dao.MyBatisDao;
import org.forten.zuoye.mapper.Book2Mapper;
import org.forten.zuoye.model.Book2;
import org.forten.zuoye.qo.Book2NameAndPriceQo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("book2Bo")
public class Book2Bo {
    @Resource
    private MyBatisDao<Book2Mapper> dao;

    @Transactional
    public int doSave(Book2 book){
        Book2Mapper bm = dao.getMapper(Book2Mapper.class);
        return bm.insertBook(book);
    }

    @Transactional(readOnly=true)
    public Book2 queryById(int id){
        Book2Mapper bm = dao.getMapper(Book2Mapper.class);
        return bm.selectById(id);
    }

    @Transactional(readOnly=true)
    public List<Book2> queryAll(){
        Book2Mapper bm = dao.getMapper(Book2Mapper.class);
        return bm.selectAll();
    }

    @Transactional
    public int updateBook(Book2 book){
        Book2Mapper bm = dao.getMapper(Book2Mapper.class);
        return bm.updateBook(book);
    }

    @Transactional
    public int deleteById(int id){
        Book2Mapper bm = dao.getMapper(Book2Mapper.class);
        return bm.deleteById(id);
    }

    @Transactional
    public List<Book2> queryByNameAndPrice(Book2NameAndPriceQo qo){
        Book2Mapper bm = dao.getMapper(Book2Mapper.class);
        return bm.selectByNameAndPrice(qo);
    }
}
