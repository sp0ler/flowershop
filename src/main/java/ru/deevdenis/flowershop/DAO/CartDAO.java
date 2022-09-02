package ru.deevdenis.flowershop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.deevdenis.flowershop.models.Cart;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDAO extends JpaRepository<Cart, Long> {
    @Query(value = "SELECT * FROM cart WHERE cookie = :cookie", nativeQuery = true)
    Optional<Cart> getCartByCookie(String cookie);

    List<Cart> findAllByEmail(String email);

    List<Cart> findAllByCookie(String cookie);

    Optional<Cart> findByCookie(String cookie);
}
