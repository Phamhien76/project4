package ra.service;

import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int userId);
    List<User> findByEmail(String email);
    List<User> findAllSort(String sortDir, String sortBy, int page, int size);
    LoginResponse login(LoginRequest loginRequest);
    boolean block(User user);
    long countUser();
}
