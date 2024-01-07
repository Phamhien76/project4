package ra.service;

import org.springframework.web.multipart.MultipartFile;
import ra.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(String proId);
    List<Product> findByNameContainsAndTitleContains(String findName, String title);
    List<Product> findAllSort(String sortDir, String sortBy, int page, int size);
    boolean save(Product product, MultipartFile avatar, MultipartFile[] otherImages);
    boolean update (Product product);
    boolean delete(String proId);
    long countProduct();
}
