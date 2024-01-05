package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.dto.response.UserResponse;
import ra.model.Categories;
import ra.model.User;
import ra.modelMap.LoginMapper;
import ra.modelMap.UserMapper;
import ra.repository.UserRepository;
import ra.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public User findById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> findByEmail(String email) {

        return userRepository.findByEmailContains(email);
    }

    @Override
    public List<User> sortBy(String sortDir, String sortBy, int page, int sizw) {
        Pageable pageable;
        if (sortDir.equals("ASC")){
            pageable = PageRequest.of(page,sizw, Sort.by(sortBy).ascending());
        }else{
            pageable = PageRequest.of(page,sizw, Sort.by(sortBy).descending());
        }
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = loginMapper.mapperRequestToEntity(loginRequest);
        Optional<User> userLogin = userRepository.login(user);
        if (userLogin.isPresent()){
            return  loginMapper.mapperEntityToResponse(userLogin.get());
        }
        return null;
    }

    @Override
    public boolean block(User user) {
        User updateUserStatus = userRepository.findById(user.getId()).get();
        updateUserStatus.setStatus(user.isStatus());
        User userSta = userRepository.save(updateUserStatus);
        return userSta != null? true:false;
    }
}
