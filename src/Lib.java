import java.util.ArrayList;

public abstract class Lib {
	
	public abstract void addBook();
	
	public abstract void displayAvailableBooks();
	
	public abstract void displayBorrowedBooks();
	
    public abstract void addMember();
    
    public abstract void borrowBook();
    
    public abstract void returnBook();
    
    public abstract void displayMembersAndBorrowedBooks();
    
    //find book method
    public Book findBookByIsbn(String isbn, ArrayList<Book> books) {
    	for(Book book : books) {
    		if(book.getIsbn().equals(isbn)) {
    			return book;
    		}
    	}
    	return null;
    }
    
    //find member method
    public Member findMemberById(int id,ArrayList<Member> members) {
    	for(Member member : members) {
    		if(member.getId() == id) {
    			return member;
    		}
    	}
    	return null;
    }



}
