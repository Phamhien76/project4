package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ra.model.Product;
import ra.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView("admin/product");
        List<Product> listProduct = productService.findAll();
        mav.addObject("listProduct", listProduct);
        return mav;
    }

    @PostMapping("/create")
    public String createProduct(Product proNew, MultipartFile avatar, MultipartFile[] otherImages){
        boolean result = productService.save(proNew,avatar,otherImages);
        if (result){
            return "redirect:findAll";
        }else{
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public ModelAndView initUpdate(String proId){
        Product updateProduct = productService.findById(proId);
        ModelAndView mav = new ModelAndView(("admin/updateProduct"));
        mav.addObject("updateProduct",updateProduct);
        return mav;

    }
    @PostMapping("/update")
    public String updatePro(Product product){
        boolean result = productService.update(product);
        if (result){
            return "redirect: findAll";
        }else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteProduct(String proId){
        boolean result = productService.delete(proId);
        if (result){
            return "redirect: findAll";
        }else {
            return "error";
        }
    }
}
