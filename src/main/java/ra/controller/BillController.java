package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Bill;
import ra.model.BillDetail;
import ra.model.User;
import ra.repository.BillDetailRepository;
import ra.service.BillService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/billController")
public class BillController {
    @Autowired
    private BillService billService;
    private final int SIZE = 3;
    @GetMapping("/findAll")
    public ModelAndView findAll(String sortDir, String sortBy, Integer page){
        ModelAndView mav = new ModelAndView("admin/bill");
        int totalPage = (int)Math.ceil((double) billService.countProduct()/(double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i<totalPage;i++){
            listPage.add(i+1);
        }
        List<Bill> listBill = billService.findAllSort(sortDir,sortBy,(page-1),SIZE);
        mav.addObject("listBill", listBill);
        mav.addObject("listPage",listPage);
        return mav;

    }

    @PostMapping("/findAllSort")
    public ModelAndView findAllSort(String sortDir, String sortBy, Integer page){
        ModelAndView mav = new ModelAndView("admin/bill");
        int totalPage = (int)Math.ceil((double) billService.countProduct()/(double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i<totalPage;i++){
            listPage.add(i+1);
        }
        List<Bill> listBill = billService.findAllSort(sortDir,sortBy,(page-1),SIZE);
        mav.addObject("listBill", listBill);
        mav.addObject("listPage",listPage);
        return mav;

    }

    @GetMapping("/findAllBD")
    public ModelAndView findAllBD(int id){
        ModelAndView mav = new ModelAndView("admin/bill");
        BillDetail billDetail = billService.finAllBD(id);
        mav.addObject("billDetail",billDetail);
        return mav;
    }



}
