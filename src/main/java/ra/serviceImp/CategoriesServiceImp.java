package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.Categories;
import ra.repository.CategoriesRepository;
import ra.service.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
  @Autowired
private CategoriesRepository categoriesRepository;


    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findById(int catalogId) {
        return categoriesRepository.findById(catalogId).get();
    }

    @Override
    public List<Categories> findCateByName(String catalogName) {
       return categoriesRepository.findByNameContains(catalogName);
    }

    @Override
    public List<Categories> sort(String sortDir, String sortBy, int page, int sizw) {
        //return categoriesRepository.findAll(Sort.sort());
        Pageable pageable;
        if (sortDir.equals("ASC")){
            pageable = PageRequest.of(page,sizw, Sort.by(sortBy).ascending());
        }else{
            pageable = PageRequest.of(page,sizw, Sort.by(sortBy).descending());
        }
        return categoriesRepository.findAll(pageable).getContent();
    }

    @Override
    public boolean save(Categories categories) {
        Categories cate = categoriesRepository.save(categories);
        return cate != null?true:false;
    }

    @Override
    public boolean update(Categories categories) {
        Categories cateUpdate = categoriesRepository.findById(categories.getId()).get();
        cateUpdate.setName(categories.getName());
        cateUpdate.setDescription(categories.getDescription());
        cateUpdate.setStatus(categories.isStatus());
        Categories cate = categoriesRepository.save(cateUpdate);
        return cate != null?true:false;
    }
    @Override
    public boolean delete(int catalogId) {
        boolean result = false;
        try {
            categoriesRepository.deleteById(catalogId);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
