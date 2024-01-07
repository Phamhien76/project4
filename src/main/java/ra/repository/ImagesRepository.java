package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.model.Bill;
import ra.model.Images;
import ra.model.Product;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Integer> {
    @Query(" select p from Product p join Images i on p.id = i.product.id")
    public List<Product> findAllProduct();
}
