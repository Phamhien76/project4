package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.Bill;
import ra.model.BillDetail;
import ra.model.Categories;
import ra.model.User;
import ra.repository.BillDetailRepository;
import ra.repository.BillRepository;
import ra.service.BillService;

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
    public BillDetail finAllBD(int id) {
        return billDetailRepository.finAllBD(id);
    }

    @Override
    public Bill findById(int billId) {
        return billRepository.findById(billId).get();
    }

    @Override
    public List<Bill> findAllSort(String sortDir, String sortBy, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,sortDir.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        return billRepository.findAll(pageable).getContent();
    }

    @Override
    public boolean update(Bill bill) {
        Bill uptateBill = billRepository.findById(bill.getId()).get();
        uptateBill.setStatus(bill.getStatus());
        Bill billSta = billRepository.save(uptateBill);
        return billSta !=null?true:false;
    }

    @Override
    public long countProduct() {
        return billRepository.count();
    }
}
