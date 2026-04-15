package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Book;

public interface Bookdao {
	List<Book> findAll();

}
