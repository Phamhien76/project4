package ra.modelMap;

import org.springframework.stereotype.Component;
import ra.dto.request.UserRequest;
import ra.dto.response.UserResponse;
import ra.model.User;

@Component
public class UserMapper implements MapperGeneric<User, UserRequest, UserResponse> {

    @Override
    public User mapperRequestToEntity(UserRequest userRequest) {
        return User.builder() .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword()).build();
    }

    @Override
    public UserResponse mapperEntityToResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getCreated(),user.isStatus());
    }
}
