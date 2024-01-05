package ra.service;

import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.dto.response.UserResponse;
import ra.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User findById(int userId);
    List<User> findByEmail(String email);
    List<User> sortBy(String sortDir, String sortBy, int page, int sizw);
    LoginResponse login(LoginRequest loginRequest);
    boolean block(User user);
}
