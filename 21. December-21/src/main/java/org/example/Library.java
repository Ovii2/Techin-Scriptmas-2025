package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Library {

    private final List<Book> books;
    private final List<Reader> readers;
    private final List<Loan> loans;
    private long nextLoanId = 1L;

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public Loan borrowBook(Reader reader, Book book, LocalDate date) {
        if (!readers.contains(reader)) {
            throw new IllegalArgumentException("Reader does not exist");
        }
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book does not exist");
        }
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("No copies available");
        }
        if (!reader.canBorrow()) {
            throw new IllegalArgumentException("Reader has reached the borrow limit");
        }
        Loan loan = new Loan(nextLoanId, book.getId(), reader.getId(), date, null, Status.ACTIVE);
        nextLoanId++;
        book.decreaseAvailableCopies();
        reader.getBorrowedBookIds().add(book.getId());
        loans.add(loan);
        return loan;
    }

    public void returnBook(Loan loan, LocalDate date) {
        if (Status.ACTIVE != loan.getStatus()) {
            throw new IllegalArgumentException("Book is already returned");
        }
        loan.setReturnDate(date);
        loan.setStatus(Status.RETURNED);

        Book book = findBookById(loan.getBookId());
        book.increaseAvailableCopies();

        Reader reader = findReaderById(loan.getReaderId());
        reader.getBorrowedBookIds().remove(loan.getBookId());
    }

    public List<Loan> getActiveLoans(Long readerId) {
        return loans.stream()
                .filter(loan -> Status.ACTIVE == loan.getStatus())
                .filter(loan -> readerId.equals(loan.getReaderId()))
                .toList();
    }

    private Book findBookById(Long bookId) {
        return books.stream()
                .filter(book -> bookId.equals(book.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book was not found"));
    }

    private Reader findReaderById(Long readerId) {
        return readers.stream()
                .filter(reader -> readerId.equals(reader.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Reader was not found"));
    }


    public void printChristmasReport(Reader reader) {
        IO.println("CHRISTMAS LIBRARY REPORT");
        for (Book book : books) {
            IO.println("%s: %d / %d %s".formatted(book.getTitle(), book.getAvailableCopies(), book.getTotalCopies(), "available"));
        }
        List<Loan> activeLoans = getActiveLoans(reader.getId());
        IO.println();
        IO.println("ACTIVE LOANS");
        for (Loan loan : activeLoans) {
            Book loanedBook = findBookById(loan.getBookId());
            IO.println("%s -> %s".formatted(reader.getName(), loanedBook.getTitle()));
        }
    }
}
