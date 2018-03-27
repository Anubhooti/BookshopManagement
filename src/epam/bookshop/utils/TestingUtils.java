package epam.bookshop.utils;

import static epam.bookshop.utils.CollectionUtils.populateStore;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import epam.bookshop.core.Book;
import epam.bookshop.exception.BookShopExceptionHandling;

public class TestingUtils {

	// All books present in the bookstore
	Map<String, Book> bookStore;
	// cart
	List<Book> cart;

	public TestingUtils() {
		try {
			bookStore = populateStore();
		} catch (ParseException e) {
			System.out.println(e);
		}
		cart = new ArrayList<>();
	}

	public void displayBooks() {
		Collection<Book> booksMap = bookStore.values();
		for (Book book : booksMap)
			System.out.println(book);
	}

	public void addToCart() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Title of Book : ");
		String title = scan.next();

		if (bookStore.containsKey(title)) {
			Book selectedBook=bookStore.get(title);
			if(selectedBook.getQuantity()>0){
				selectedBook.setQuantity(selectedBook.getQuantity()-1);
				cart.add(selectedBook);
				System.out.println("Book added to cart");
			}
			else
			{
				throw new BookShopExceptionHandling("Not in Stock");
			}
		} else {
			throw new BookShopExceptionHandling("This title is not available in book store");
		}
	}

	public void deleteFromCart() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Title of Book : ");
		Book book = new Book(scan.next());

		int index = cart.indexOf(book);
		scan.close();
		if (index == -1)
			throw new BookShopExceptionHandling("This book is not present in the cart");
		cart.remove(index);
		
		System.out.println("Book deleted from cart successfully");
	}

	public void showCart() {
		System.out.println("**** CART ****");
		for (Book book : cart)
			System.out.println(book);
	}
	
	public void checkout() {
		double total = 0;
		System.out.println("Cart Contents : ");
		for (Book book : cart) {
			System.out.println(book.getTitle());
			total += book.getPrice();
		}
		System.out.println("****Total amount to be paid : " + total + " ****");
		System.out.println("Have a nice day...Visit Again :) ");
	}

}
