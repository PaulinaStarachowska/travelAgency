package pl.sda.service;

import pl.sda.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User getById(Integer id);

    List<User> getAll();

    void delete(Integer id);
}
