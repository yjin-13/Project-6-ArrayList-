import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Book{
  
    
  public String title;
  public String subject;
  public int year;
  public int pages;
  public double rating;
  public static Scanner sc = new Scanner(System.in);

  public Book(String title, String subject, int year, int pages, double rating) {
       this.title = title;
       this.subject = subject;
       this.year = year;
       this.pages = pages;
       this.rating = rating;
   }
// get title method
  public String getTitle() {
      return title;
    }
//get subject method
  public String getSubject() {
      return subject;
    }
//get year method
  public int getYear() {
      return year;
    }
//get pages method
  public int getPages() {
      return pages;
    }
//get rating method
  public double getRating() {
      return rating;
    }
  
//create 20 books by using for loop
  public static void createBook(ArrayList<Book>books){
    String[] subjects = {"Programming", "Data Structures", "Algorithms", "Operating Systems", "Gaming"};
        Random r = new Random();

        for (int i = 1; i <= 20; i++) {
            String title = "Book" + i;
            int year = 1980 + r.nextInt(40);
            int pages = 50 + r.nextInt(951);
            double rating = 0.1 + (10.0 - 0.1) * r.nextDouble();
            String subject = subjects[r.nextInt(5)];
            Book book = new Book(title, subject, year, pages, rating);
          

            books.add(book);
        }
  }
  
//display all of the books in order
  public static void listBooks(ArrayList<Book>books) {
    System.out.println("List of all books: ");
    for (int i = 0; i < books.size(); i++) {
        System.out.println("Book " + (i + 1) + ": " + books.get(i));
    }
  }

  
//sort all of the books by year in the arraylist 
  public static void sortByYear(ArrayList<Book>books) {
    int n = books.size();
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            Book book1 = books.get(j);
            Book book2 = books.get(minIndex);
            if (book1.getYear() < book2.getYear()) {
                minIndex = j;
            }
        }
        Book temp = books.get(minIndex);
        books.set(minIndex, books.get(i));
        books.set(i, temp);
    }
}

  
//sort all of the books by pages in the arraylist  
  public static void sortByPages(ArrayList<Book>books){
    
    int n = books.size();
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            Book book1 = books.get(j);
            Book book2 = books.get(minIndex);
            if (book1.getPages() < book2.getPages()) {
                minIndex = j;
            }
        }
        Book temp = books.get(minIndex);
        books.set(minIndex, books.get(i));
        books.set(i, temp);
    }
}


//sort all of the books by rating in the arraylist
  public static void sortByRating(ArrayList<Book>books){
    int n = books.size();
    for (int i = 0; i < n - 1; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < n; j++) {
            Book book1 = books.get(j);
            Book book2 = books.get(maxIndex);
            if (book1.getRating() > book2.getRating()) {
                maxIndex = j;
            }
        }
        Book temp = books.get(maxIndex);
        books.set(maxIndex, books.get(i));
        books.set(i, temp);
    }
}

//display the books of that subject by asking for user input
  public static void displaySubjectBooks(ArrayList<Book>books) {
    String subject = sc.nextLine();
    System.out.println("Books with subject " + subject + ": ");
    for (int i = 0; i < books.size(); i++) {
        Book book = books.get(i);
        if (book.getSubject().equals(subject)) {
            System.out.println("Book " + (i + 1) + ": " + book);
        }
    }
}

  
//search book by names
  public static void searchBook(ArrayList<Book>books) {
    String name = sc.nextLine();
    boolean found = false;
    for (int i = 0; i < books.size(); i++) {
        Book book = books.get(i);
        if (book.getTitle().equalsIgnoreCase(name)) {
            System.out.println("Book found: " + book);
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Book not found");
    }
}

  
//add a new book to the list by asking all of the information from user input
  public static void addBook(ArrayList<Book>books){
    System.out.println("Could you provide me all of these information: name, subject, year, pages, rating?");
    String name = sc.nextLine();
    String subject = sc.nextLine();
    int year = sc.nextInt();
    int pages = sc.nextInt();
    double rating = sc.nextDouble();
    books.add(new Book(name, subject, year, pages, rating));
  }
  
//main method
  public static void main(String[] args) {
    ArrayList<Book> books = new ArrayList<>();
    createBook(books);
    
    int choice;
        do {
            //print out the menu
            System.out.println("1. List all books");
            System.out.println("2. Display books sorted by year");
            System.out.println("3. Display books sorted by pages");
            System.out.println("4. Display books sorted by rating");
            System.out.println("5. Display books by subject");
            System.out.println("6. Search for a book");
            System.out.println("7. Add a book");
            System.out.println("8. Exit");
          
            //ask for choice and run different methods
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    listBooks(books);
                    break;
                case 2:
                    sortByYear(books);
                    listBooks(books);
                    break;
                case 3:
                    sortByPages(books);
                    listBooks(books);
                    break;
                case 4:
                    sortByRating(books);
                    listBooks(books);
                    break;
                case 5:
                    displaySubjectBooks(books);
                    break;
                case 6:
                    searchBook(books);
                    break;
                case 7:
                    addBook(books);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
    }

}
  