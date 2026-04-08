import java.util.*;

class Book {
	private String title;
	private int year;

	public Book(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}
}

public class Library {
	private List<Book> books = new ArrayList<>();

	public void addBook(String title, int year) {
		books.add(new Book(title, year));
	}

	class BookShelf implements Iterable<Book> {
		private int minYear;

		public BookShelf(int minYear) {
			this.minYear = minYear;
		}

		@Override
		public Iterator<Book> iterator() {
			return books.stream()
            .filter(book -> book.getYear() >= minYear)
            .iterator();
		}
	}

	public BookShelf getRecentBooks(int minYear) {
		return new BookShelf(minYear);
	}
}