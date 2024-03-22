package QuestionMaintask3;

import java.util.Scanner;

	class Book {
	    private int bookID;
	    private String title;
	    private String author;
	    private boolean isAvailable;

	    // Constructor
	    public Book(int bookID, String title, String author) {
	        this.bookID = bookID;
	        this.title = title;
	        this.author = author;
	        this.isAvailable = true; // By default, a newly added book is available
	    }

	    // Getters and Setters
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

	    public void setAvailable(boolean available) {
	        isAvailable = available;
	    }

	    @Override
	    public String toString() {
	        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
	    }
	}

	class Library {
	    private Book[] books;
	    private int size;

	    // Constructor
	    public Library(int capacity) {
	        this.books = new Book[capacity];
	        this.size = 0;
	    }

	    // Method to add a book to the library
	    public void addBook(Book book) {
	        if (size < books.length) {
	            books[size++] = book;
	            System.out.println("Book \"" + book.getTitle() + "\" added to the library.");
	        } else {
	            System.out.println("Library is full. Cannot add more books.");
	        }
	    }

	    // Method to remove a book from the library by ID
	    public void removeBook(int bookID) {
	        for (int i = 0; i < size; i++) {
	            if (books[i].getBookID() == bookID) {
	                System.out.println("Book \"" + books[i].getTitle() + "\" removed from the library.");
	                // Shift remaining books to the left
	                for (int j = i; j < size - 1; j++) {
	                    books[j] = books[j + 1];
	                }
	                books[size - 1] = null; // Remove the last reference
	                size--;
	                return;
	            }
	        }
	        System.out.println("Book with ID " + bookID + " not found in the library.");
	    }

	    // Method to search for a book by ID
	    public Book searchBookByID(int bookID) {
	        for (int i = 0; i < size; i++) {
	            if (books[i].getBookID() == bookID) {
	                return books[i];
	            }
	        }
	        return null; // Book not found
	    }

	    // Method to display all books in the library
	    public void displayBooks() {
	        if (size == 0) {
	            System.out.println("Library is empty.");
	        } else {
	            System.out.println("Books in the library:");
	            for (int i = 0; i < size; i++) {
	                System.out.println(books[i]);
	            }
	        }
	    }
	}

	public class Question3_1 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Library library = new Library(10);

	        while (true) {
	            System.out.println("\nLibrary System Menu:");
	            System.out.println("1. Add a book");
	            System.out.println("2. Remove a book");
	            System.out.println("3. Search for a book by ID");
	            System.out.println("4. Display all books");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Book ID: ");
	                    int bookID = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Title: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter Author: ");
	                    String author = scanner.nextLine();
	                    library.addBook(new Book(bookID, title, author));
	                    break;
	                case 2:
	                    System.out.print("Enter Book ID to remove: ");
	                    int removeID = scanner.nextInt();
	                    library.removeBook(removeID);
	                    break;
	                case 3:
	                    System.out.print("Enter Book ID to search: ");
	                    int searchID = scanner.nextInt();
	                    Book foundBook = library.searchBookByID(searchID);
	                    if (foundBook != null) {
	                        System.out.println("Book found:");
	                        System.out.println(foundBook);
	                    } else {
	                        System.out.println("Book with ID " + searchID + " not found.");
	                    }
	                    break;
	                case 4:
	                    library.displayBooks();
	                    break;
	                case 5:
	                    System.out.println("Exiting Library System. Goodbye!");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	            }
	        }
	    }
	}
	

