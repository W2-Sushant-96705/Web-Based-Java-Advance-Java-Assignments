package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Book;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookRowMapper bookRowMapper;
	
	@Override
	public List<Book> findAll() {
		String sql = "SELECT * FROM books";
		List<Book> list = jdbcTemplate.query(sql, bookRowMapper);
		return list;
	}
	@Override
	public List<Book> findBySubject(String subject) {
		String sql = "SELECT * FROM books WHERE subject=?";
		List<Book> list = jdbcTemplate.query(sql, bookRowMapper, subject);
		return list;
	}
	@Override
	public Book findById(int id) {
		String sql = "SELECT * FROM books WHERE id=?";
		List<Book> list = jdbcTemplate.query(sql, bookRowMapper, id);
		return list.size() == 0 ? null : list.get(0);
	}
	@Override
	public int save(Book b) {
		String sql = "INSERT INTO books (id, name, author, subject, price) VALUES (?, ?, ?, ?, ?)";
		int cnt = jdbcTemplate.update(sql, b.getId(), b.getName(), b.getAuthor(), b.getSubject(), b.getPrice());
		return cnt;
	}
	@Override
	public int update(Book b) {
		String sql = "UPDATE  books SET name=?, author=?, subject=?, price=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice(), b.getId());
		return cnt;
	}
	@Override
	public int updatePrice(int bookId, double newPrice) {
		String sql = "UPDATE books SET price=? WHERE id=?";
		int cnt = jdbcTemplate.update(sql, newPrice, bookId);
		return cnt;
	}
	@Override
	public int deleteById(int bookId) {
		String sql = "DELETE FROM books WHERE id=?";
		int cnt = jdbcTemplate.update(sql, bookId);
		return cnt;
	}
}
