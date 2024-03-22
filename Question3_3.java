package QuestionMaintask3;


	import java.util.Scanner;
	import java.util.ArrayList;
	class Book {
	    private int bookID;
	    private String title;
	    private String author;
	    private boolean isAvailable;

	    public Book(int bookID, String title, String author, boolean isAvailable) {
	        this.bookID = bookID;
	        this.title = title;
	        this.author = author;
	        this.isAvailable = isAvailable;
	    }

	    public int getBookID() {
	        return bookID;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public boolean isAvailable() {
	        return isAvailable;
	    }

	    public void setAvailable(boolean isAvailable) {
	        this.isAvailable = isAvailable;
	    }

	    @Override
	    public String toString() {
	        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
	    }
	}

	class Library {
	    private ArrayList<Book> books;

	    public Library() {
	        books = new ArrayList<Book>();
	    }

	    public void addBook(Book book) {
	        books.add(book);
	    }

	    public void removeBook(int bookID) {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getBookID() == bookID) {
	                books.remove(i);
	                break;
	            }
	        }
	    }

	    public void displayBooks() {
	        for (int i = 0; i < books.size(); i++) {
	            System.out.println((i + 1) + ". " + books.get(i));
	        }
	    }

	    public void checkOutBook(int bookID) {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getBookID() == bookID) {
	                if (books.get(i).isAvailable()) {
	                    books.get(i).setAvailable(false);
	                } else {
	                    System.out.println("The book is not available.");
	                }
	                break;
	            }
	        }
	    }

	    public void returnBook(int bookID) {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getBookID() == bookID) {
	                if (!books.get(i).isAvailable()) {
	                    books.get(i).setAvailable(true);
	                } else {
	                    System.out.println("The book is already available.");
	                }
	                break;
	            }
	        }
	    }
	}

	public class Question3_3 {
	    public static void main(String[] args) {
	        Library library = new Library();
	        Scanner scanner = new Scanner(System.in);

	        // Add books to the library
	        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", true));
	        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", true));
	        library.addBook(new Book(3, "Pride and Prejudice", "Jane Austen", true));

	        // Display all books in the library
	        library.displayBooks();

	        // Check out a book
	        library.checkOutBook(1);

	        // Display all books in the library
	        library.displayBooks();

	        // Return a book
	        library.returnBook(1);

	        // Display all books in the library
	        library.displayBooks();

	        // Remove a book
	        library.removeBook(2);

	        // Display all books in the library
	        library.displayBooks();

	        scanner.close();
	    }
	}


