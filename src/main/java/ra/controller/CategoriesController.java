package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Categories;
import ra.service.CategoriesService;

import java.util.List;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mav = new ModelAndView("admin/categories");
        List<Categories> listCategories = categoriesService.findAll();
        mav.addObject("listCategories",listCategories);
        return mav;
    }

    @PostMapping("/create")
    public String createCate(Categories cateNew ){
        boolean result = categoriesService.save(cateNew);
        if (result){
            return "redirect:findAll";
        }else{
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public ModelAndView initUpdate(int catalogId){
        Categories updateCategories = categoriesService.findById(catalogId);
        ModelAndView mav = new ModelAndView(("admin/updateCategories"));
        mav.addObject("updateCategories",updateCategories);
        return mav;

    }
    @PostMapping("/update")
    public String updateCate(@ModelAttribute Categories cateUpdate){
        boolean result = categoriesService.update(cateUpdate);
        if (result){
            return "redirect: findAll";
        }else {
            return "error";
        }
    }
    @GetMapping("/delete")
    public String deleteCate(int catalogId){
        boolean result = categoriesService.delete(catalogId);
        if (result){
            return "redirect: findAll";
        }else {
            return "error";
        }
    }


}
