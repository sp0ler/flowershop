package ru.deevdenis.flowershop.servises.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.deevdenis.flowershop.DAO.CartDAO;
import ru.deevdenis.flowershop.DAO.RoleDAO;
import ru.deevdenis.flowershop.DAO.UserDAO;
import ru.deevdenis.flowershop.models.Role;
import ru.deevdenis.flowershop.models.User;
import ru.deevdenis.flowershop.servises.UserService;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CartDAO cartDAO;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(username).orElse(null);
        if (user == null) throw new UsernameNotFoundException("User not found!");

        user.updateLastLogonDate();
        userDAO.save(user);

        return user;
    }

    @Override
    @Transactional
    public boolean saveUser(User user) {
        String email = user.getEmail();

        if(userDAO.findByEmail(email).orElse(null) != null) return false;

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        save(user);

        return true;
    }

    @Override
    @Transactional
    public boolean banUser(Long id) {
        User user = userDAO.findById(id).orElse(null);

        if (user != null) {
            user.setActive(false);
            userDAO.save(user);
            return true;
        }

        return false;
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        Optional<User> user = userDAO.findById(id);
        return user.orElse(new User());
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) { return userDAO.findByEmail(email).orElse(null); }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void save(User user) { userDAO.save(user); }

}
