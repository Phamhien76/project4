package ra.service;

import ra.model.Bill;
import ra.model.BillDetail;

import java.util.List;

public interface BillService {
    List<Bill> findAll();
    List<BillDetail> finAllBD (int id);
    Bill findById(int billId);
    List<Bill> findAllByStatus(String status, int page, int size);
    List<Bill> findAllSort(String sortDir, String sortBy, int page, int size);
    boolean update (int billId,int status);
    long countBill();
    Double totalRevenueDay(int day);
    Double totalRevenueMonth(int month);
    Double totalRevenueYear(int year);

}
