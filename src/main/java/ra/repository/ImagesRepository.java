package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.Images;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer> {
//    @Query(" select p from Product p join Images i on p.id = i.product.id")
//    public List<Product> findAllProduct();
    List<Images> findAllByProductImageId(String id);
}
