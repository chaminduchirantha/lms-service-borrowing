package lk.ijse.gdse.borrowingservice.services;

import lk.ijse.gdse.borrowingservice.dto.BorrowDto;

import java.util.List;

public interface BorrowService {
    BorrowDto saveBorrow(BorrowDto borrowDto);
    BorrowDto updateBorrow(Long id, BorrowDto borrowDto);
    BorrowDto getBorrowById(Long id);
    List<BorrowDto> getAllBorrows();
    void deleteBorrow(Long id);
    List<BorrowDto> getBorrowsByUserId(String userId);
}