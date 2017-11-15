package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import main.TestProject;
import model.Book;

public class BookTest {
	TestProject project = new TestProject();
	List<Book> bookList = null;

	@Test
	public void testHighestPrice() throws IOException {
		bookList = project.loadBookList("TestFile.csv");
		Book testBook = Book.highestPricedBook(bookList);
		assertTrue(testBook.getAuthorName().equals("\"Larry McCaffery\""));
		assertTrue(testBook.getPrice() == 22.94);
		assertTrue(testBook != null);
	}
	
	@Test
	public void testLowestPrice() throws IOException {
		bookList = project.loadBookList("TestFile.csv");
		Book testBook = Book.lowestPricedBook(bookList);
		assertTrue(testBook.getTitle().equals("\"Marked by Fate: A Young Adult Science Fiction Collection with Augmented Reality: Read, Watch, Listen. The new ultimate reading experience\""));
		assertTrue(testBook.getYearPublished() == 2017);
		assertTrue(testBook != null);
	}
	
	@Test
	public void testAveragePrice() throws IOException {
		bookList = project.loadBookList("TestFile.csv");
		String averageCost = Book.averageBookPrice(bookList);
		assertFalse(averageCost.equals((null)));
		assertFalse(averageCost.equalsIgnoreCase("1234"));
		assertTrue(averageCost.equals("15.26"));
	}

	@Test
	public void testYoungerBooks() throws IOException {
		bookList = project.loadBookList("TestFile.csv");
		List<Book> youngBooks = Book.booksXYearsOldOrLess(bookList, 3);
		assertTrue(youngBooks.size() == 3);
		assertTrue(youngBooks.get(0).getAuthorName().equals("\"Rich Horton\""));
		assertTrue(youngBooks.get(0).getPrice() == 19.95);
	}
	
	@Test
	public void testOlderBooks() throws IOException {
		bookList = project.loadBookList("TestFile.csv");
		List<Book> oldBooks = Book.booksOlderThanXYears(bookList, 3);
		assertTrue(oldBooks.size() == 3);
		assertFalse(oldBooks.get(0).getAuthorName().equals("\"Rich Horton\""));
	}

}
