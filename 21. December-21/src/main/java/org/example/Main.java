package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    void main() {
        List<Book> books = new ArrayList<>();
        List<Reader> readers = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();

        Library library = new Library(books, readers, loans);

        Book cleanCode = new Book(1L, "Clean Code", "Robert C. Martin", 2, 2);
        Book pragmatic = new Book(2L, "The Pragmatic Programmer", "Andrew Hunt / David Thomas", 1, 1);
        Book refactoring = new Book(3L, "Refactoring", "Martin Fowler", 1, 1);

        library.addBook(cleanCode);
        library.addBook(pragmatic);
        library.addBook(refactoring);

        Reader alice = new Reader(1L, "Alice", 2, new ArrayList<>());
        Reader bob = new Reader(2L, "Bob", 1, new ArrayList<>());

        library.registerReader(alice);
        library.registerReader(bob);

        LocalDate date = LocalDate.now();

        Loan loan1 = library.borrowBook(alice, cleanCode, date);
        IO.println("BORROW OK: Alice borrowed \"%s\"".formatted(cleanCode.getTitle()));

        library.borrowBook(alice, cleanCode, date);
        IO.println("BORROW OK: Alice borrowed \"%s\"".formatted(cleanCode.getTitle()));

        try {
            library.borrowBook(bob, cleanCode, date);
            IO.println("BORROW OK: Bob borrowed \"%s\"".formatted(cleanCode.getTitle()));
        } catch (IllegalArgumentException exception) {
            IO.println(
                    "BORROW FAILED: Bob cannot borrow \"%s\" (%s)"
                            .formatted(cleanCode.getTitle(), exception.getMessage())
            );
        }

        library.returnBook(loan1, date);
        IO.println("RETURN OK: \"%s\" returned by Alice".formatted(cleanCode.getTitle()));

        IO.println();
        library.printChristmasReport(alice);
    }
}
