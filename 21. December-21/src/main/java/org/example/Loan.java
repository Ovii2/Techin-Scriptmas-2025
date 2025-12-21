package org.example;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loan {

    private Long id;
    private Long bookId;
    private Long readerId;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private Status status;
}
