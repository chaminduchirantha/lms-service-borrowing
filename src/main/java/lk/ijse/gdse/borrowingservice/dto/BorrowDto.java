package lk.ijse.gdse.borrowingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDto {
    private Long id;
    private String userId;
    private String userName;
    private String bookName;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status;
}
