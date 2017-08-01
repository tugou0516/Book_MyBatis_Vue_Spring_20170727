package org.forten.zuoye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.forten.zuoye.model.Book2;
import org.forten.zuoye.qo.Book2NameAndPriceQo;

public interface Book2Mapper {
	@Results(id="book2Map1",value={
			@Result(property="id",column="id",id=true),
			@Result(property="name",column="name"),
			@Result(property="author",column="author"),
			@Result(property="publisher",column="publisher"),
			@Result(property="price",column="price"),
			@Result(property="pubDate",column="pub_date"),
	})
	@Select("SELECT id,name,author,publisher,pub_date,price,discount,creat_time "
			+ "FROM test_book2 WHERE id=#{id} ")
	Book2 selectById(int id);

	@Select("SELECT id,name,author,publisher,pub_date,price,discount,creat_time "
			+ "FROM test_book2 ORDER BY id ")
	List<Book2> selectAll();
	
	@Select("SELECT id,name,author,publisher,pub_date,price,discount,creat_time "
			+ "FROM test_book2 "
			+ "WHERE publisher LIKE #{publisher} AND price BETWEEN #{priceMin} AND #{priceMax}")
	List<org.forten.zuoye.model.Book2> selectByPublisherAndPrice(@Param("publisher") String publisher, @Param("priceMin") double priceMin, @Param("priceMax") double priceMax);

	@Insert("INSERT INTO test_book2 (name,author,publisher,pub_date,price,discount) "
			+ "VALUES (#{name},#{author},#{publisher},#{pubDate},#{price},#{discount})")
	int insertBook(org.forten.zuoye.model.Book2 book);
	
	@Update("UPDATE test_book2 SET "
			+ "name=#{name},publisher=#{publisher},pub_date=#{pubDate},price=#{price},discount=#{discount} WHERE id=#{id}")
	int updateBook(Book2 book);
	
	@Delete("DELETE FROM test_book2 WHERE id=#{id}")
	int deleteById(int id);

	@Results(id="book2Map2",value={
			@Result(property="id",column="id",id=true),
			@Result(property="name",column="name"),
			@Result(property="author",column="author"),
			@Result(property="publisher",column="publisher"),
			@Result(property="price",column="price"),
			@Result(property="pubDate",column="pub_date"),
	})
	@SelectProvider(type=Book2NameAndPriceQo.class, method="getSql")
	List<Book2> selectByNameAndPrice(Book2NameAndPriceQo qo);
}
