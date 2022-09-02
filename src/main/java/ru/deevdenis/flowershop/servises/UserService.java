package ru.deevdenis.flowershop.servises;

import ru.deevdenis.flowershop.models.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    User findUserById(Long id);

    boolean banUser(Long id);

    List<User> getAllUsers();

    User findUserByEmail(String email);

    void save(User user);
}
