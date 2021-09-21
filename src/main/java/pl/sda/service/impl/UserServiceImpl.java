package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Trip;
import pl.sda.model.User;
import pl.sda.repository.UserRepository;
import pl.sda.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
