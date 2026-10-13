import library.books.*;
import library.members.*;
import library.transactions.*;

public class MainApp {
    public static void main(String[] args) {
        new Book().addBook();
        new Member().registerMember();
        new Transaction().issueBook();
    }
}
