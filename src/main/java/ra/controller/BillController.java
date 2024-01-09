package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Bill;
import ra.model.BillDetail;
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
        int totalPage = (int)Math.ceil((double) billService.countBill()/(double) SIZE);
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
    public ModelAndView findAllSort(@ModelAttribute(name = "sortDir" ) String sortDir,
                                    @ModelAttribute(name = "sortBy" ) String sortBy){
        ModelAndView mav = new ModelAndView("admin/bill");
        int totalPage = (int)Math.ceil((double) billService.countBill()/(double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i<totalPage;i++){
            listPage.add(i+1);
        }
        List<Bill> listBill = billService.findAllSort(sortDir,sortBy,0,SIZE);
        mav.addObject("listBill", listBill);
        mav.addObject("listPage",listPage);
        return mav;

    }

    @GetMapping("/findAllBD")
    public ModelAndView findAllBD(@RequestParam(name = "billId",defaultValue = "") int id){
        ModelAndView mav = new ModelAndView("admin/billDetail");
        List<BillDetail> listBillDetail = billService.finAllBD(id);
        mav.addObject("listBillDetail",listBillDetail);
        return mav;
    }

    @GetMapping("/initUpdate")
    public ModelAndView initUpdateBill(int billId){
        Bill billUpdateStatus = billService.findById(billId);
        ModelAndView mav = new ModelAndView("admin/updateBill");
        mav.addObject("billUpdateStatus", billUpdateStatus);
        return mav;
    }

    @GetMapping("/update")
    public String updateStatus(@RequestParam("id") int id,@RequestParam("status") int status){

        boolean result = billService.update(id,status);
        if (result){
            return "redirect:findAll?page=1&sortDir=ASC&sortBy=id";
        }
        return "error";
    }
    @GetMapping("/searchSortBill")
    public ModelAndView searchSortBill(@RequestParam("status") String status){
        ModelAndView mav = new ModelAndView("admin/bill");
        int totalPage = (int)Math.ceil((double) billService.countBill()/(double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i<totalPage;i++){
            listPage.add(i+1);
        }
        List<Bill> listBill = billService.findAllByStatus(status,0,SIZE);
        mav.addObject("listBill",listBill);
        mav.addObject("listPage",listPage);
        return mav;

    }

}
