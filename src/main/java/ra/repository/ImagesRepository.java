package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.Images;

public interface ImagesRepository extends JpaRepository<Images, Integer> {
}
