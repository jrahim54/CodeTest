package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import main.TestProject;
import model.Book;

public class ProgramTest {
	TestProject project = new TestProject();
	@Test
	public void testLoadBookList() throws IOException {
		
		List<Book> bookList = project.loadBookList("TestFile.csv");
		assertTrue(bookList.size() == 6);
		assertTrue(bookList.get(0).getTitle().equals("\"The Year’s Best Science Fiction & Fantasy 2017 Edition\""));
		assertTrue(bookList.get(0).getYearPublished() == 2017);
		assertFalse(bookList.get(0).getYearPublished() == 2300);
	}
	
	

}
