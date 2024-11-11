package vn.hoidanit.laptopshop.service;

import java.util.List;

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

    public List<User> getAllUser() {
        return this.uRepository.findAll();
    }

    public List<User> getAllUserByEmail(String email) {
        return this.uRepository.findByEmail(email);
    }

    public User findUserById(long id) {
        return this.uRepository.findUserById(id);
    }

    public User deleteUserById(long id) {
        return this.uRepository.deleteById(id);
    }

}
