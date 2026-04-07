import java.util.*;
 
public class Library {
    public static class Book {
        private String title;
        private int    year;
        public Book(String title, int year) {
            this.title = title;
            this.year  = year;
        }
        public String getTitle() { return title; }
        public int    getYear()  { return year;  }
        @Override
        public String toString() {
            return title + ": " + year;
        }
    }
    private List<Book> books = new ArrayList<>();
 
    public void addBook(Book book) {
        books.add(book);
    }
    public class BookShelf implements Iterable<Book> {
 
        private int minYear;
 
        public BookShelf(int minYear) {
            this.minYear = minYear;
        }
 
        @Override
        public Iterator<Book> iterator() {
            List<Book> filtered = new ArrayList<>();
            for (Book b : books) {        
                                if (b.getYear() >= minYear) {
                    filtered.add(b);
                }
            }
            return new Iterator<Book>() {
                int index = 0;
 
                @Override
                public boolean hasNext() {
                    return index < filtered.size();
                }
 
                @Override
                public Book next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    return filtered.get(index++);
                }
            };
        }
    }
    public BookShelf getShelf(int minYear) {
        return new BookShelf(minYear);
    }
}