package ra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.email = :email AND u.password = :password")
    Optional<User> login(@Param("email") String email, @Param("password") String password);

    Page<User> findAllByEmailContains(String email, Pageable pageable);
}
