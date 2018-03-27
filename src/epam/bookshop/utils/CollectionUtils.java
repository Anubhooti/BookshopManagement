package epam.bookshop.utils;

import static epam.bookshop.core.Book.*;

import java.text.ParseException;
import java.util.*;

import epam.bookshop.core.*;

public class CollectionUtils {
	public static Map<String, Book> populateStore() throws ParseException {
		HashMap<String, Book> b = new HashMap<>();
		
		b.put("TFIOS", new Book("TFIOS", "John Green", 350, sdf.parse("20-5-2011"), "Romance",0));
		b.put("Twilight", new Book("Twilight", "aunt", 2600, sdf.parse("23-8-2014"), "Thriller",3));
		b.put("Twilight2", new Book("Twilight2", "aunt", 1600, sdf.parse("20-9-2016"), "Thriller",1));
		b.put("Twilight3", new Book("Twilight3", "aunt", 3600, sdf.parse("23-11-2016"), "Thriller",5));
		b.put("Twilight4", new Book("Twilight4", "aunt", 600, sdf.parse("23-8-2014"), "Thriller",10));
		return b;
	}
}
