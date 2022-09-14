package ru.deevdenis.flowershop.servises.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deevdenis.flowershop.DAO.CartDAO;
import ru.deevdenis.flowershop.models.Cart;
import ru.deevdenis.flowershop.servises.CartService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAO cartDAO;

    @Override
    @Transactional
    public void save(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    @Transactional
    public Cart findCartByCookie(String cookie) {
        Optional<Cart> cart = cartDAO.getCartByCookie(cookie);
        return cart.orElse(null);
    }

    @Override
    @Transactional
    public Cart findCartById(long id) {
        Optional<Cart> cart = cartDAO.findById(id);
        return cart.orElse(null);
    }

    @Override
    @Transactional
    public List<Cart> findAll() {
        return cartDAO.findAll();
    }

    @Override
    @Transactional
    public void saveAll(List<Cart> list) {
        cartDAO.saveAll(list);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        cartDAO.deleteById(id);
    }

    @Override
    @Transactional
    public List<Cart> findAllByEmail(String email) {
        return cartDAO.findAllByEmail(email);
    }

    @Override
    @Transactional
    public List<Cart> findAllByCookie(String cookie) {
        return cartDAO.findAllByCookie(cookie);
    }
}
