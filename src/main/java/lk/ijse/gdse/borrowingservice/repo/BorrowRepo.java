package lk.ijse.gdse.borrowingservice.repo;

import lk.ijse.gdse.borrowingservice.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long> {
    List<Borrow> findByUserId(String userId);
}
