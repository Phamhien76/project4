package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.BillDetail;

import java.util.List;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {

//    @Query("select bd from BillDetail bd join Bill b on bd.bill.id = :id")
//    List<BillDetail>  finAllBD (@Param("id") int id);

    List<BillDetail> findAllByBillId(Integer id);

    @Query("select sum(bd.total) from Bill b join BillDetail bd on b.id = bd.bill.id where day (b.crated) = :day and b.status = 4")
    Double totalRevenueDay(@Param("day") int day);

    @Query("select sum(bd.total) from Bill b join BillDetail bd on b.id = bd.bill.id where month (b.crated) = :month and b.status = 4")
    Double totalRevenueMonth(@Param("month") int month);

    @Query("select sum(bd.total) from Bill b join BillDetail bd on b.id = bd.bill.id where year (b.crated) = :year and b.status = 4")
    Double totalRevenueYear(@Param("year") int year);




}
