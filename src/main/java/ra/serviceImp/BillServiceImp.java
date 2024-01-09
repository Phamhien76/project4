package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.Bill;
import ra.model.BillDetail;
import ra.repository.BillDetailRepository;
import ra.repository.BillRepository;
import ra.service.BillService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public List<BillDetail> finAllBD(int id) {
        return billDetailRepository.findAllByBillId(id);
    }

    @Override
    public Bill findById(int billId) {
        return billRepository.findById(billId).get();
    }

    @Override
    public List<Bill> findAllByStatus(String status, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        List<Bill> listBillStatus = new ArrayList<>();
        if (status.equalsIgnoreCase("Đã hủy") ){
            listBillStatus =billRepository.findAllByStatus(0,pageable).getContent();
        }if(status.equalsIgnoreCase("Đang chờ")){
            listBillStatus = billRepository.findAllByStatus(1,pageable).getContent();
        }if (status.equalsIgnoreCase("Đã duyệt")){
            listBillStatus = billRepository.findAllByStatus(2,pageable).getContent();
        }if (status.equalsIgnoreCase("Đang giao")){
            listBillStatus =billRepository.findAllByStatus(3,pageable).getContent();
        }if(status.equalsIgnoreCase("Đã nhận hàng")) {
            listBillStatus =billRepository.findAllByStatus(4,pageable).getContent();
        }


        return listBillStatus;
    }

    @Override
    public List<Bill> findAllSort(String sortDir, String sortBy, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,sortDir.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        return billRepository.findAll(pageable).getContent();
    }

    @Override
    public boolean update(int billId,int status) {
        boolean result = false;
        try {
            Bill uptateBill = billRepository.findById(billId).get();
            uptateBill.setStatus(status);
            Bill billSta = billRepository.save(uptateBill);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public long countBill() {
        return billRepository.count();
    }

    @Override
    public Double totalRevenueDay(int day) {
        Double result = billDetailRepository.totalRevenueDay(day);
        if(result == null) {
            return 0.0;
        }
        return result;
    }

    @Override
    public Double totalRevenueMonth(int month) {
        return billDetailRepository.totalRevenueMonth(month);
    }

    @Override
    public Double totalRevenueYear(int year) {
        return billDetailRepository.totalRevenueYear(year);
    }
}
