package epam.bookshop.utils;

import static epam.bookshop.utils.CollectionUtils.populateStore;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import epam.bookshop.core.Book;
import epam.bookshop.exception.BookShopException;
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
	public void addToCart(Scanner scan) throws BookShopException {
		System.out.println("Enter Title of Book : ");
		String title = scan.next();

		if (bookStore.containsKey(title)) {
			Book selectedBook = bookStore.get(title);
			if (selectedBook.getQuantity() > 0) {
				selectedBook.setQuantity(selectedBook.getQuantity() - 1);
				cart.add(selectedBook);
				System.out.println("Book added to cart");
			} else {
				throw new BookShopException(" #### Sorry..Out of Stock ####");
			}
		} else {
			throw new BookShopException("#### This title is not available in book store ####");
		}
	}
	public void deleteFromCart(Scanner scan) throws BookShopException {
		System.out.println("Enter Title of Book : ");
		String title = scan.next();
		Book book = new Book(title);
		int index = cart.indexOf(book);

		if (index == -1)
			throw new BookShopException("#### This book is not present in the cart ####");

		// when book is present in the Cart , remove it and update its quantity
		// in book store
		cart.remove(index);
		book = bookStore.get(title);
		book.setQuantity(book.getQuantity() + 1);
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
