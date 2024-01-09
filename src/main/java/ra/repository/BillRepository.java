package ra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    Page<Bill> findAllByStatus(int status, Pageable pageable);

}
