import java.util.Scanner;

public class LibraryMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;
        
        String[] menuItems = {
        		"1.Add Book",
        		"2.Add Member",
        		"3.Display Available Books",
        		"4.Display Borrow Book",
        		"5.Borrow Book",
        		"6.Display Members and Borrowed Books",
        		"7.Return Borrowed Book",
        		"8.To exit"
        };
          
//		do-while loop for menu card
        do {
        	System.out.println("_____________Library Management System_____________");
        	
            for(String item : menuItems) 
            	System.out.println(item+"  ");
            
        	System.out.print("Choose Operation : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                	library.addMember();
                    break;
                case 3:
                	library.displayAvailableBooks();
                    break;
                case 4:
                	library.displayBorrowedBooks();
                    break;
                case 5:
                	library.borrowBook();
                    break;
                case 6:
                    library.displayMembersAndBorrowedBooks();
                    break;
                case 7:
                	library.returnBook();
                	break;
                case 8:
                    System.out.println("Exiting Library Management System...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);

        scanner.close();
    }
}