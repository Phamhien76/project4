package ra.repository;

import ra.model.Bill;

import java.util.List;

public interface BillRepository {
    List<Bill> findAll();
}
