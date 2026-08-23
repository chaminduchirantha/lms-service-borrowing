package lk.ijse.gdse.borrowingservice.services.impl;

import lk.ijse.gdse.borrowingservice.dto.BorrowDto;
import lk.ijse.gdse.borrowingservice.entity.Borrow;
import lk.ijse.gdse.borrowingservice.repo.BorrowRepo;
import lk.ijse.gdse.borrowingservice.services.BorrowService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final ModelMapper modelMapper;
    private final BorrowRepo borrowRepo;

    @Override
    public BorrowDto saveBorrow(BorrowDto borrowDto) {
        Borrow borrow = modelMapper.map(borrowDto, Borrow.class);
        Borrow savedBorrow = borrowRepo.save(borrow);
        return modelMapper.map(savedBorrow, BorrowDto.class);
    }

    @Override
    public BorrowDto updateBorrow(Long id, BorrowDto borrowDto) {
        Borrow existingBorrow = borrowRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found with ID: " + id));

        existingBorrow.setUserId(borrowDto.getUserId());
        existingBorrow.setUserName(borrowDto.getUserName());
        existingBorrow.setBookName(borrowDto.getBookName());
        existingBorrow.setBorrowDate(borrowDto.getBorrowDate());
        existingBorrow.setReturnDate(borrowDto.getReturnDate());
        existingBorrow.setStatus(borrowDto.getStatus());

        Borrow updatedBorrow = borrowRepo.save(existingBorrow);
        return modelMapper.map(updatedBorrow, BorrowDto.class);
    }

    @Override
    public BorrowDto getBorrowById(Long id) {
        Borrow borrow = borrowRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found with ID: " + id));
        return modelMapper.map(borrow, BorrowDto.class);
    }

    @Override
    public List<BorrowDto> getAllBorrows() {
        List<Borrow> borrows = borrowRepo.findAll();
        return modelMapper.map(borrows, new TypeToken<List<BorrowDto>>() {}.getType());
    }

    @Override
    public void deleteBorrow(Long id) {
        Borrow borrow = borrowRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found with ID: " + id));
        borrowRepo.delete(borrow);
    }

    @Override
    public List<BorrowDto> getBorrowsByUserId(String userId) {
        List<Borrow> borrows = borrowRepo.findByUserId(userId);
        return modelMapper.map(borrows, new TypeToken<List<BorrowDto>>() {}.getType());
    }
}