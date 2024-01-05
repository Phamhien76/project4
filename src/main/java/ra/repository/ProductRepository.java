package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameContainsAndAndPrice(String findName);

}
