package epam.bookshop.tester;

import java.util.*;
import java.util.zip.CheckedOutputStream;

import epam.bookshop.core.*;
import epam.bookshop.exception.*;
import epam.bookshop.utils.TestingUtils;

public class Tester {
	public static void main(String[] args) throws Exception {
		boolean exit = false;
		TestingUtils testHelper = new TestingUtils();
		try (Scanner sc = new Scanner(System.in);) {
			while (exit==false) {
				System.out.println("\n ***** MENU *****");
				System.out.println("1) Display available books to user");
				System.out.println("2) Add Book to the Cart");
				System.out.println("3) Remove Book from the Cart");
				System.out.println("4) Show Cart");
				System.out.println("5) Check Out");
				System.out.println(" Enter your choice : ");
				switch (sc.nextInt()) {
				case 1:
					testHelper.displayBooks();
					break;
				case 2:
					testHelper.addToCart();
					break;
				case 3:
					testHelper.deleteFromCart();
					break;
				case 4:
					testHelper.showCart();
					break;
				case 5:
					testHelper.checkout();
					exit = true;
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			}
		}
	}
}
