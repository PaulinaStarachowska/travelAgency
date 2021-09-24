package pl.sda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.sda.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(User user);

    User getById(Integer id);

    List<User> getAll();

    void delete(Integer id);

    UserDetails loadUserByUsername(String username);

    void encodePassword(User user);

}
