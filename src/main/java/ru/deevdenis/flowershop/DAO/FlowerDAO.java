package ru.deevdenis.flowershop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.deevdenis.flowershop.models.Category;
import ru.deevdenis.flowershop.models.Flower;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlowerDAO extends JpaRepository<Flower, Integer> {
    @Query(value = "SELECT * FROM flowers WHERE category_name = :categoryName", nativeQuery = true)
    List<Flower> getFlowersByCategory(@Param("categoryName") String categoryName);

    @Query(value = "DELETE FROM flowers WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    void deleteById(int id);

    List<Flower> findAllByCategoryName(String categoryName);

    List<Flower> findAllByTitle(String title);

    List<Flower> findAllByTitleContainsIgnoreCase(String title);

}
