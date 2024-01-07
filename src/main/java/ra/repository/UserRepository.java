package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.dto.response.UserResponse;
import ra.model.Categories;
import ra.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmailContains(String fullName);

    @Query("select u from User u where u.email = :email AND u.password = :password")
    Optional<User> login(@Param("email") String email, @Param("password") String password);

}
