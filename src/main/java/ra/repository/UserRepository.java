package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.dto.response.UserResponse;
import ra.model.Categories;
import ra.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmailContains(String fullName);
    Optional<User> login(User user);

}
