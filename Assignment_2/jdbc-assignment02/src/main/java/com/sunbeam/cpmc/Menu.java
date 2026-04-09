package com.sunbeam.cpmc;

import java.util.Scanner;

public class Menu {
	public static int MainMenu(Scanner sc) {
		System.out.println("=======================");
		System.out.println("\n1. Find by Book ID: ");
		System.out.println("2. Find All");
		System.out.println("3. Find by Name: ");
		System.out.println("4. Find by Author: ");
		System.out.println("5. Find by Subject: ");
//		System.out.println("6.Find ");
		System.out.println("7.Insert Data: ");
		System.out.println("7.Update Data: ");
		System.out.println("7.Delete Data by ID: ");
		System.out.println("0. Exit\n");
		System.out.println("=======================");
		return sc.nextInt();
	}
}
