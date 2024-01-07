package ra.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.model.Bill;
import ra.model.BillDetail;
import ra.model.Categories;
import ra.model.User;

import java.util.List;
import java.util.Optional;

public interface BillService {
    List<Bill> findAll();
    BillDetail finAllBD (int id);
    Bill findById(int billId);
    List<Bill> findAllSort(String sortDir, String sortBy, int page, int size);
    boolean update (Bill bill);
    long countProduct();

}
