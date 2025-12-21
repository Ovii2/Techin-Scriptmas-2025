package org.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    private Long id;
    private String title;
    private String author;
    private Integer totalCopies;
    private Integer availableCopies;

    public boolean isAvailable() {
        if (availableCopies < 0 || availableCopies > totalCopies) {
            throw new IllegalStateException("Book copy count is in an invalid state");
        }
        return availableCopies > 0;
    }

    public void decreaseAvailableCopies() {
        if (availableCopies <= 0) {
            throw new IllegalArgumentException("This book is currently not available");
        }
        availableCopies--;
    }

    public void increaseAvailableCopies() {
        if (availableCopies >= totalCopies) {
            throw new IllegalStateException("All copies of this book are already in the library");
        }
        availableCopies++;
    }
}
