package com.sunbeam.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@RequestMapping("/v2")
//@Controller
@RestController
public class BookRestControllerV2 {
	@Autowired
	private BookDao bookDao;

	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks() {
		List<Book> list = bookDao.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") int bookId) {
		Book b = bookDao.findById(bookId);
		return ResponseEntity.ok(b);
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> addBook(@RequestBody Book b) {
		int cnt = 0;
		try {
			cnt = bookDao.save(b);
		}catch (Exception e) {
			e.printStackTrace();
			//return ResponseEntity.internalServerError().build();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		//URI uri = URI.create("/books/"+b.getId());
		//return ResponseEntity.created(uri).build();
		//return ResponseEntity.created(uri).body(cnt);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") int bookId, @RequestBody Book b) {
		int cnt = 0;
		try {
			b.setId(bookId);
			cnt = bookDao.update(b);
			return ResponseEntity.ok(cnt);
		}catch (Exception e) {
			e.printStackTrace();
			//return ResponseEntity.internalServerError().build();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@PatchMapping("/books/{id}")
	public ResponseEntity<?> updateBookPrice(@PathVariable("id") int bookId, @RequestBody Book b) {
		int cnt = 0;
		try {
			cnt = bookDao.updatePrice(bookId, b.getPrice());
			return ResponseEntity.ok(cnt);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable("id") int bookId) {
		int cnt = bookDao.deleteById(bookId);
		if(cnt == 0)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(cnt);
	}
}










