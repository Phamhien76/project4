package ra.service;

import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer userId);
    List<User> findByEmail(String email, int page, int size);
    List<User> findAllSort(String sortDir, String sortBy, int page, int size);
    LoginResponse login(LoginRequest loginRequest);
    boolean block(User user);
    long countUser();
}
