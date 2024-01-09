package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
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
    public User findById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> findByEmail(String email,int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return userRepository.findAllByEmailContains(email,pageable).getContent();
    }

    @Override
    public List<User> findAllSort(String sortDir, String sortBy, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,sortDir.equals("ASC")? Sort.Direction.ASC: Sort.Direction.DESC,sortBy);
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> userLogin = userRepository.login(loginRequest.getEmail(),loginRequest.getPassword());
        if (userLogin.isPresent()){
            return  loginMapper.mapperEntityToResponse(userLogin.get());
        }
        return null;
    }

    @Override
    public boolean block(User user) {
        boolean result = false;
        try {
            User updateUserStatus = userRepository.findById(user.getId()).get();
            updateUserStatus.setStatus(!user.isStatus());
            User userSta = userRepository.save(updateUserStatus);
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public long countUser() {
        return userRepository.count();
    }
}
