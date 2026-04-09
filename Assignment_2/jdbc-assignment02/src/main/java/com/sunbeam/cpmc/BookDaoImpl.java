package com.sunbeam.cpmc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements AutoCloseable, BookDao {

    private Connection con;

    public BookDaoImpl() throws Exception {
        con = DbUtil.connect();
    }

    @Override
    public void close() throws Exception {
        if (con != null) {
            con.close();
        }
    }

    @Override
    public Book findById(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String subject = rs.getString("subject");
                    int price = rs.getInt("price");

                    Book book = new Book(id, name, author, subject, price);
                    return book;

                }
            }
        }
        return null;
    }

    @Override
    public List<Book> findAll() throws Exception {
        String sql = "SELECT * FROM books";
        List<Book> list = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String subject = rs.getString("subject");
                    int price = rs.getInt("price");

                    Book book = new Book(id, name, author, subject, price);
                    list.add(book);
                }
            }
        }
        return list;
    }

    @Override
    public Book findByName(String name) throws Exception {
        String sql = "SELECT * FROM books WHERE name=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String author = rs.getString("author");
                    String subject = rs.getString("subject");
                    int price = rs.getInt("price");
                    Book book = new Book(id, name, author, subject, price);
                    return book;
                }
            }
        }
        return null;

    }

    @Override
    public Book findByAuthor(String author) throws Exception {
        String sql = "SELECT * FROM books WHERE author=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, author);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String subject = rs.getString("subject");
                    int price = rs.getInt("price");
                    Book book = new Book(id, name, author, subject, price);
                    return book;
                }
            }
        }
        return null;

    }

    @Override
    public Book findBySubject(String subject) throws Exception {
        String sql = "SELECT * FROM books WHERE subject=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, subject);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    int price = rs.getInt("price");
                    Book book = new Book(id, name, author, subject, price);
                    return book;
                }
            }
        }
        return null;
    }
    
    @Override
	public int insertFunc(Book book) throws Exception {
		String sql = "INSERT INTO books (name, author,subject,price) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getSubject());
			stmt.setInt(4, book.getPrice());
			int count = stmt.executeUpdate();
			return count;
		}
	
    }
  }

