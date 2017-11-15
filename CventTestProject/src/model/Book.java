package model;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Book {
	private String title;
	private String authorName;
	private Integer yearPublished;
	private double price;
	/**
	 * @param title
	 * @param authorName
	 * @param yearPublished
	 * @param price
	 */
	public Book(String title, String authorName, Integer yearPublished, Double price) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.yearPublished = yearPublished;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(Integer yearPublished) {
		this.yearPublished = yearPublished;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public static Book highestPricedBook(List<Book> books)
	{
		Book returnBook = null;
		for(Book b : books)
		{
			if(returnBook == null || b.getPrice() > returnBook.getPrice())
				returnBook = b;
		}
		return returnBook;	
	}
	public static Book lowestPricedBook(List<Book> books)
	{
		Book returnBook = null;
		for(Book b : books)
		{
			if(returnBook == null || b.getPrice() < returnBook.getPrice())
				returnBook = b;
		}
		return returnBook;	
	}
	
	public static String averageBookPrice(List<Book> books)
	{
		double averagePrice = 0;
		for(Book b : books)
		{
			averagePrice = averagePrice + b.getPrice();
		}
		return new DecimalFormat("#.##").format(averagePrice/books.size());	
	}
	
	public static List<Book> booksOlderThanXYears(List<Book> books, int yearsOlder)
	{
		List<Book> returnList = new LinkedList<Book>();
		int yearToCheck = Calendar.getInstance().get(Calendar.YEAR);
		yearToCheck = yearToCheck - yearsOlder;
		
		for(Book b : books)
		{
			if(b.getYearPublished() < yearToCheck)
				returnList.add(b);
		}
		return returnList;
	}
	
	public static List<Book> booksXYearsOldOrLess(List<Book> books, int howOld)
	{
		List<Book> returnList = new LinkedList<Book>();
		int yearToCheck = Calendar.getInstance().get(Calendar.YEAR);
		yearToCheck = yearToCheck - howOld;
		
		for(Book b : books)
		{
			if(b.getYearPublished() >= yearToCheck)
				returnList.add(b);
		}
		return returnList;
	}
}
