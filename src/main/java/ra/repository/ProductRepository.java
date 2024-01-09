package ra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByNameOrTitleContainingIgnoreCase(String findName, String title, Pageable pageable);





}
