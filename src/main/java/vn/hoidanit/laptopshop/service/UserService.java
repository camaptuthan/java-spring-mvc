package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository uRepository;

    public UserService(UserRepository uRepository) {
        this.uRepository = uRepository;
    }

    public User SaveUser(User user) {
        return this.uRepository.save(user);
    }

}
