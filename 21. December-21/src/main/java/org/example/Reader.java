package org.example;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Reader {

    private Long id;
    private String name;
    private Integer borrowLimit;
    private List<Long> borrowedBookIds;

    public boolean canBorrow() {
        return borrowedBookIds.size() < borrowLimit;
    }
}
