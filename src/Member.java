import java.util.ArrayList;

public class Member {

    private int id;
    private String name;
    private ArrayList<Book> borrowedBooks;

    //constructor
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //method for returning borrowedBooks
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    //adding borrowed book
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    //removing borrowed book
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }
}