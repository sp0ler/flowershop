package ru.deevdenis.flowershop.servises;

import ru.deevdenis.flowershop.models.Cart;
import ru.deevdenis.flowershop.models.Flower;

import java.util.List;
import java.util.Optional;

public interface CartService {
    void save(Cart cart);

    Cart findCartByCookie(String cookie);

    Cart findCartById(long id);

    List<Cart> findAll();

    List<Cart> findAllByEmail(String email);

    List<Cart> findAllByCookie(String cookie);

    void saveAll(List<Cart> list);

    void deleteById(long id);
}
