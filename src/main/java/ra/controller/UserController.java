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
import ra.dto.response.UserResponse;
import ra.model.User;
import ra.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ModelAndView getAllUser(){
        ModelAndView mav = new ModelAndView("admin/user");
        List<User> listUser = userService.findAll();
        mav.addObject("listUser", listUser);
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
            modelMap.addAttribute("error","Username or password incorrect");
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
        mav.addObject("listUser", listUser);
        return mav;
    }

}
