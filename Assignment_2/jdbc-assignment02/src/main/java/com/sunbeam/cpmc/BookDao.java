package com.sunbeam.cpmc;

import java.util.List;

public interface BookDao extends AutoCloseable{
	Book findById(int id) throws Exception;
	List<Book> findAll() throws Exception;
	Book findByName(String name) throws Exception;
	Book findByAuthor(String author) throws Exception;
	Book findBySubject(String subject) throws Exception;
	int insertFunc(Book book) throws Exception;
		
}
