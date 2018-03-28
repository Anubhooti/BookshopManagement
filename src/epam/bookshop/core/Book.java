package epam.bookshop.core;

import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

public class Book {
	private String title;
	private String author;
	private double price;
	private Date publishDate;
	private String category;
	private int quantity;
	public static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("dd-MM-yy");
	}

	public Book(String title, String author, double price, Date publishDate, String category, int quantity) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishDate = publishDate;
		this.category = category;
		this.quantity = quantity;
	}

	public Book(String tb) {
		title = tb;
	}

	public double getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Book))
			return false;
		return title.equals(((Book) o).title);
	}

	@Override
	public String toString() {
		return "Book -> " + title + ", by " + author  + ", quantity=" + quantity+", $" + price + ", category=" + category;
	}

		
}
