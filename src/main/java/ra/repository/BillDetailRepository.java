package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.Bill;
import ra.model.BillDetail;
import ra.model.Product;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {

    @Query("select bd from BillDetail bd join Bill b on bd.bill.id = :id")
    public BillDetail  finAllBD (@Param("id") int id);




}
