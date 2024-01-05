package ra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.Categories;

import java.util.List;
@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    List<Categories> findByNameContains(String catalogName);
}
