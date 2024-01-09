package ra.modelMap;

import org.springframework.stereotype.Component;
import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.model.User;

@Component
public class LoginMapper implements MapperGeneric<User, LoginRequest, LoginResponse> {
    @Override
    public User mapperRequestToEntity(LoginRequest loginRequest) {
        return User.builder().email(loginRequest.getEmail())
                .password(loginRequest.getPassword()).build();
    }

    @Override
    public LoginResponse mapperEntityToResponse(User user) {
        return new LoginResponse(user.getId(), user.getEmail(), user.isPermission(),user.getName());
    }
}
