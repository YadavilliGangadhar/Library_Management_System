import java.util.ArrayList;
import java.util.Scanner;

public class Library extends Lib{
	
	//creating 2 arrayLists for storing books and members
	 private ArrayList<Book> books = new ArrayList<>();
	 private ArrayList<Member> members = new ArrayList<>();
	 
	 private Scanner sc = new Scanner(System.in);

	    //add book method
	    public void addBook() {
	        System.out.print("Enter book title: ");
	        String title = sc.nextLine();

	        System.out.print("Enter book author: ");
	        String author = sc.nextLine();

	        System.out.print("Enter book ISBN: ");
	        String isbn = sc.nextLine();

	        books.add(new Book(title, author, isbn, true));
	        System.out.println("( Book Added uccessfully )");
	    }

	    //display available books method
	    public void displayAvailableBooks() {
	        if (books.isEmpty()) {
	            System.out.println("No books available in the library.");
	        } else {
	            System.out.println("Available Books:");
	            for (Book book : books) {
	                if (book.isAvailable()) {
	                    System.out.println(book);
	                }
	            }
	        }
	    }

	    //display borrowed books method
	    public void displayBorrowedBooks() {
	        if (books.isEmpty()) {
	            System.out.println("No books borrowed from the library");
	        } else {
	            System.out.println("Borrowed Books:");
	            for (Book book : books) {
	                if (!book.isAvailable()) {
	                    System.out.println(book);
	                }
	            }
	        }
	    }
	    
	    //add member method
	    public void addMember() {
	    	System.out.print("Enter member id: ");
	    	int id = sc.nextInt();
	    	sc.nextLine();	//empty
	    	
	    	System.out.print("Enter member name: ");
	    	String name = sc.nextLine();
	    	
	    	members.add(new Member(id, name));
	    	System.out.println("Member added successfully");
	    	
	    }

	    //borrow book method
	    public void borrowBook() {
	        System.out.print("Enter your member ID: ");
	        int memberId = sc.nextInt();
	        sc.nextLine(); //empty
	        
	        Member member = findMemberById(memberId, members);
	        if(member != null) {
	        	System.out.print("Enter book ISBN to borrow: ");
	 	        String isbn = sc.nextLine();
	 	        
	 	        Book book = findBookByIsbn(isbn, books);
	 	        if (book != null && book.isAvailable()) {
		 	    	  book.setAvailable(false);
	            	  member.addBorrowedBook(book);
	            	  System.out.println("Book borrowed successfully.");
	 	        }else {
	 	        	  System.out.println("Book not found or unavailable for borrowing.");
	 	        }
	        }else {
	        	System.out.println("Member not found");
	        }
	 	        
	    }

	    //return book method
	    public void returnBook() {
	        System.out.print("Enter your member ID: ");
	        int memberId = sc.nextInt();
	        sc.nextLine();	//empty
	        
	        Member member = findMemberById(memberId, members);
	            if(member != null) {
	            	System.out.print("Enter book ISBN to return: ");
	     	        String isbn = sc.nextLine();

	     	        Book book = findBookByIsbn(isbn, books);
	     	        if (book != null && !book.isAvailable()) {
	     	            book.setAvailable(true);
	     	            member.removeBorrowedBook(book);
	     	            System.out.println("Book returned successfully.");
	     	        } else {
	     	            System.out.println("Book not found or already available.");
	     	        }
	            }else {
	            	System.out.println("Member not found");
	            }
	       
	    }

	    //display members and borrowed books method
	    public void displayMembersAndBorrowedBooks() {
	        if (members.isEmpty()) {
	            System.out.println("No members registered in the library.");
	        } else {
	            System.out.println("Members and Borrowed Books:");
	            for (Member member : members) {
	                System.out.println("Member ID: " + member.getId());
	                System.out.println("Member Name: " + member.getName());
	                System.out.println("Borrowed Books:");
	                boolean hasBorrowedBooks = false;
	                for (Book book : books) {
	                    if (!book.isAvailable() && member.getBorrowedBooks().contains(book)) {
	                        System.out.println(book);
	                        hasBorrowedBooks = true;
	                    }
	                }
	                if (hasBorrowedBooks == false) {
	                    System.out.println("No books borrowed.");
	                }
	            }
	        }
	    }
	        
}