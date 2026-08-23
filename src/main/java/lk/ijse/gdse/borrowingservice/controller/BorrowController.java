package lk.ijse.gdse.borrowingservice.controller;

import lk.ijse.gdse.borrowingservice.dto.BorrowDto;
import lk.ijse.gdse.borrowingservice.services.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/borrowing")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;

    @PostMapping("/create")
    public ResponseEntity<BorrowDto> saveBorrow(@RequestBody BorrowDto borrowDto) {
        BorrowDto savedBorrow = borrowService.saveBorrow(borrowDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBorrow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowDto> updateBorrow(@PathVariable Long id, @RequestBody BorrowDto borrowDto) {
        BorrowDto updatedBorrow = borrowService.updateBorrow(id, borrowDto);
        return ResponseEntity.ok(updatedBorrow);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowDto> getBorrowById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowService.getBorrowById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BorrowDto>> getAllBorrows() {
        return ResponseEntity.ok(borrowService.getAllBorrows());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
        return ResponseEntity.ok("Borrow record deleted successfully!");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowDto>> getBorrowsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(borrowService.getBorrowsByUserId(userId));
    }
}