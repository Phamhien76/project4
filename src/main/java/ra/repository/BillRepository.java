package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.model.Bill;
import ra.model.BillDetail;
import ra.model.User;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
