package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.model.Bill;
import ra.model.Product;
import ra.model.User;
import ra.service.BillService;
import ra.service.ProductService;
import ra.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillService billService;

    private final int SIZE = 3;

    @GetMapping("/findAll")
    public ModelAndView getAllUser(String sortDir, String sortBy, Integer page){
        ModelAndView mav = new ModelAndView("admin/user");
        int totalPage = (int)Math.ceil((double) userService.countUser()/(double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i<totalPage;i++){
            listPage.add(i+1);
        }
        List<User> listUser = userService.findAllSort(sortDir,sortBy,(page-1),SIZE);
        mav.addObject("listUser", listUser);
        mav.addObject("listPage",listPage);
        return mav;
    }

    @PostMapping("/findAllSort")
    public ModelAndView findAllSort(String sortDir, String sortBy, Integer page){
        ModelAndView mav = new ModelAndView("admin/user");
        int totalPage = (int)Math.ceil((double) userService.countUser()/(double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i<totalPage;i++){
            listPage.add(i+1);
        }
        List<User> listUser = userService.findAllSort(sortDir,sortBy,(page-1),SIZE);
        mav.addObject("listUser", listUser);
        mav.addObject("listPage",listPage);
        return mav;
    }


    @GetMapping("/wellCome")
    public String wellComUser(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("userName")){
                modelMap.addAttribute("userName", cookie.getValue());
                break;
            }
        }
        return "user/userPage";
    }
    @PostMapping("/login")
    public String login(LoginRequest loginRequest, ModelMap modelMap, HttpServletResponse response, HttpServletRequest request){
        LoginResponse loginResponse = userService.login(loginRequest);
        if (loginResponse == null){
            modelMap.addAttribute("error","Email or password incorrect");
            return "login";
        }
        Cookie cookieUserId = new Cookie("userId", loginResponse.getId()+"");
        Cookie cookieEmail = new Cookie("email", loginResponse.getEmail());
        Cookie cookiePermission = new Cookie("permission", String.valueOf(loginResponse.isPermission()));
        response.addCookie(cookieUserId);
        response.addCookie(cookieEmail);
        response.addCookie(cookiePermission);
        if (loginResponse.isPermission()){
            return "redirect:getData";

        }
        return "redirect:wellCome";
    }
    @GetMapping("/loginGet")
    public String loginGet(){
        return "login";
    }
    @GetMapping("/initUpdate")
    public ModelAndView initUpdateStatus(int userId){
        User userUpdateStatus = userService.findById(userId);
        ModelAndView mav = new ModelAndView("admin/updateUser");
        mav.addObject("userUpdateStatus", userUpdateStatus);
        return mav;
    }

@PostMapping("/update")
    public String updateStatus(User user){
        boolean result = userService.block(user);
        if (result){
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/getData")
    public ModelAndView getData(){
        ModelAndView mav = new ModelAndView("dashboard");
        List<User> listUser = userService.findAll();
        int active =0;
        int inactive = 0;
        for (User user : listUser){
            if (user.isStatus()==true){
                active +=1;

            }else {
                inactive +=1;
            }
        }

        mav.addObject("userActive", active);
        mav.addObject("userInactive",inactive);

        List<Product> listProduct = productService.findAll();
        int productActive =0;
        int productInactive = 0;
        for (Product product:listProduct){
            if (product.isStatus()==true){
                productActive +=1;

            }else {
                productInactive +=1;
            }
        }

        mav.addObject("productActive", productActive);
        mav.addObject("productInactive",productInactive);

        List<Bill> listBill = billService.findAll();
        int cancel0 =0;
        int waiting1 = 0;
        int approved2 = 0;
        int delivering3 = 0;
        int received4 = 0;
        for (Bill bill:listBill){
            if (bill.getStatus()==0){
                cancel0 +=1;

            }else if (bill.getStatus()==1){
                waiting1 +=1;
            }else if (bill.getStatus()==2){
                approved2 +=1;
            }else if (bill.getStatus()==3){
                delivering3 +=1;
            }else {
                received4 +=1;
            }
        }

        mav.addObject("cancel0", cancel0);
        mav.addObject("waiting1",waiting1);
        mav.addObject("approved2", approved2);
        mav.addObject("delivering3",delivering3);
        mav.addObject("received4", received4);
        return mav;


    }

}
