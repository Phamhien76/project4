package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Categories;
import ra.model.Product;
import ra.service.CategoriesService;
import ra.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesService categoriesService;
    private final int SIZE = 3;

    @GetMapping("/findAll")
    public ModelAndView findAll(String sortDir, String sortBy, Integer page) {
        ModelAndView mav = new ModelAndView("admin/product");
        //Tính tổng pro
        int totalPage = (int) Math.ceil((double) productService.countProduct() / (double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            listPage.add(i + 1);
        }
        List<Product> listProduct = productService.findAllSort(sortDir, sortBy, (page - 1), SIZE);
        mav.addObject("listProduct", listProduct);
        mav.addObject("listPage", listPage);
        return mav;
    }

    @PostMapping("/findAllSort")
    public ModelAndView findAllSort(String sortDir, String sortBy, Integer page) {
        ModelAndView mav = new ModelAndView("admin/product");
        //Tính tổng pro
        int totalPage = (int) Math.ceil((double) productService.countProduct() / (double) SIZE);
        List<Integer> listPage = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            listPage.add(i + 1);
        }
        List<Product> listProduct = productService.findAllSort(sortDir, sortBy, 0, SIZE);
        mav.addObject("listProduct", listProduct);
        mav.addObject("listPage", listPage);
        return mav;
    }

    @GetMapping("/initCreate")
    public ModelAndView initCreate() {
        ModelAndView mav = new ModelAndView("admin/newProduct");
        List<Categories> listCategories = categoriesService.findAll();
        mav.addObject("listCategories", listCategories);
        return mav;
    }

    @PostMapping("/create")
    public String createProduct(Product newProduct, MultipartFile avatar, MultipartFile[] otherImages ){

        boolean result = productService.save(newProduct, avatar, otherImages);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public ModelAndView initUpdate(String proId) {
        Product updateProduct = productService.findById(proId);
        ModelAndView mav = new ModelAndView(("admin/updateProduct"));
        mav.addObject("updateProduct", updateProduct);
        return mav;

    }

    @PostMapping("/update")
    public String updatePro(Product product) {
        boolean result = productService.update(product);
        if (result) {
            return "redirect: findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteProduct(String proId) {
        boolean result = productService.delete(proId);
        if (result) {
            return "redirect: findAll";
        } else {
            return "error";
        }
    }
}
