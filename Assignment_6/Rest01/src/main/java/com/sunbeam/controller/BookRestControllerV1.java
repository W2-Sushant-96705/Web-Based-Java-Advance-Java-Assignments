package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;

@RequestMapping("/v1")
@RestController
public class BookRestControllerV1 {

	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		List<Book> list = bookDao.findAll();
		return list;
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int bookId) {
		Book b = bookDao.findById(bookId);
		return b;
	}
	
	@PostMapping("/books")
	public int addBook(@RequestBody Book b) {
		try {
			int cnt = bookDao.save(b);
			return cnt;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@PutMapping("/books/{id}")
	public int updateBook(@PathVariable("id") int bookId, @RequestBody Book b) {
		try {
			b.setId(bookId);
			int cnt = bookDao.update(b);
			return cnt;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@PatchMapping("/books/{id}")
	public int updateBookPrice(@PathVariable("id") int bookId, @RequestBody Book b) {
		try {
			int cnt = bookDao.updatePrice(bookId, b.getPrice());
			return cnt;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@DeleteMapping("/books/{id}")
	public int deleteBookById(@PathVariable("id") int bookId) {
		int cnt = bookDao.deleteById(bookId);
		return cnt;
	}
}
