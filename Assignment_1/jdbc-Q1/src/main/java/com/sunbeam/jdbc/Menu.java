package com.sunbeam.jdbc;

import java.util.Scanner;

public class Menu {
	public static int MainMenu(Scanner sc) {

	System.out.println("\n========================");
	System.out.println("\n1. Display all Users.");
	System.out.println("2. Insert new User.");
	System.out.println("3. Change Password for the given User Id.");
	System.out.println("4. Delete User with given Id.");
	System.out.println("0. Exit.\n");
	System.out.println("==========================");
	return sc.nextInt();
	}
	
}
