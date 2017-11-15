package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import model.Book;

public class TestProject {
	public static void main(String[] args) throws IOException  {
		TestProject program = new TestProject();
		program.runProgram();


	}
	public void runProgram() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter file name containing book info: ");
		String fileName = br.readLine();
		
		List<Book> listOfBooks = loadBookList(fileName);
		Book lowestPricedBook = Book.lowestPricedBook(listOfBooks);
		Book highestPricedBook = Book.highestPricedBook(listOfBooks);
		System.out.println("The highest costing Book was " + highestPricedBook.getTitle() + " costing " + highestPricedBook.getPrice());
		System.out.println("The lowest costing Book was " + lowestPricedBook.getTitle() + " costing " + lowestPricedBook.getPrice());
		System.out.println("The average book price was " + Book.averageBookPrice(listOfBooks));
		System.out.println("The books older than 10 years old are as follows: ");
		for(Book b : Book.booksOlderThanXYears(listOfBooks, 10))
		{
			System.out.println("Book Title " + b.getTitle() + ", By " +
					b.getAuthorName() + ", in the year " + b.getYearPublished() + 
					", costing " + b.getPrice());
		}
		System.out.println("The books younger than or equal to 5 years old are as follows: ");
		for(Book b : Book.booksXYearsOldOrLess(listOfBooks, 5))
		{
			System.out.println("Book Title " + b.getTitle() + ", By " +
					b.getAuthorName() + ", in the year " + b.getYearPublished() + 
					", costing " + b.getPrice());
		}
	}
	public List<Book> loadBookList(String fileName) throws IOException
	{
		List<Book> listOfBooks = new LinkedList<Book>();
		BufferedReader br = null;
		String resultLine = null;
		try 
		{
			br = new BufferedReader(new FileReader(fileName));
			while ((resultLine = br.readLine()) != null) 
			{
				String[] result = resultLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
				if(result.length % 4 != 0)
					System.out.println("There was an error with the size of input line " + result);
				else
					listOfBooks.add(new Book(result[0], result[1],
							Integer.parseInt(result[2]), Double.parseDouble(result[3])));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listOfBooks;
	}

}
