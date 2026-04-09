package com.sunbeam.cpmc;

import java.util.List;
import java.util.Scanner;

public class tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (BookDao bookDao = new BookDaoImpl()) {

            int choice;
            while ((choice = Menu.MainMenu(sc)) != 0) {

                switch (choice) {

                    case 1: {

                        System.out.print("Enter User Id: ");
                        int id = sc.nextInt();
                        Book book = bookDao.findById(id);
                        if (book == null) {
                            System.out.println("User Not Found."); 
                        }else {
                            System.out.println("Found " + book);
                        }

                    }
                    break;

                    case 2: {

                        List<Book> bookList = bookDao.findAll();
                        for (Book book : bookList) {
                            System.out.println(book);
                        }

                    }
                    break;

                    case 3: {

                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        Book book = bookDao.findByName(name);
                        if (book == null) {
                            System.out.println("Book Not Found."); 
                        }else {
                            System.out.println("Found " + book);
                        }

                    }
                    break;

                    case 4: {

                        System.out.print("Enter Author: ");
                        String author = sc.next();
                        Book book = bookDao.findByAuthor(author);
                        if (book == null) {
                            System.out.println("Book Not Found."); 
                        }else {
                            System.out.println("Found " + book);
                        }

                    }
                    break;

                    case 5: {

                        System.out.print("Enter Subject: ");
                        String subject = sc.next();
                        Book book = bookDao.findBySubject(subject);
                        if (book == null) {
                            System.out.println("Book Not Found."); 
                        }else {
                            System.out.println("Found " + book);
                        }

                    }
                    break;
                    
                    case 6:{
                    	
                    }break;
                    
                    case 7:{
                    	
                    	System.out.print("Enter Name: ");
            			String name = sc.next();
            			System.out.print("Enter Author: ");
            			String author = sc.next();
            			System.out.print("Enter Subject: ");
            			String subject = sc.next();
            			System.out.print("Enter Price: ");
            			int price = sc.nextInt();
            			Book book = new Book(0, name, author,subject,price);
            			int count = bookDao.insertFunc(book);
            			System.out.println("User Inserted: " + count);
                    	
                    }break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
