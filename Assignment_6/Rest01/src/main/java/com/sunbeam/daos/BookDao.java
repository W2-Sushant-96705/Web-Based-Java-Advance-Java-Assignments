package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Book;

public interface BookDao {
	List<Book> findAll();
	int save(Book b);
	List<Book> findBySubject(String subject);
	Book findById(int id);
	int update(Book b);
	int updatePrice(int bookId, double newPrice);
	int deleteById(int bookId);

}
