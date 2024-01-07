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
    public List<Categories> findAllSort(String sortDir, String sortBy, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,sortDir.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        return categoriesRepository.findAll(pageable).getContent();

    }

    @Override
    public boolean save(Categories categories) {
        boolean result = false;
        try {
            categoriesRepository.save(categories);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean update(Categories categories) {
        boolean result = false;
        try {
            Categories cateUpdate = categoriesRepository.findById(categories.getId()).get();
            cateUpdate.setName(categories.getName());
            cateUpdate.setDescription(categories.getDescription());
            cateUpdate.setStatus(categories.isStatus());
            Categories cate = categoriesRepository.save(cateUpdate);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
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

    @Override
    public long countProduct() {
        return categoriesRepository.count();
    }
}
