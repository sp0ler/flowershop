package ru.deevdenis.flowershop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.deevdenis.flowershop.models.FlowerImages;

@Repository
public interface FlowerImagesDAO extends JpaRepository<FlowerImages, Integer> {
    @Query(value = "DELETE FROM flowers_image WHERE flower_id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);
}
