package ru.deevdenis.flowershop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.deevdenis.flowershop.models.Category;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
    @Query(
            value = "SELECT * FROM categories WHERE category_name_eng = :categoryNameEng OR category_name = :categoryNameEng",
            nativeQuery = true
    )
    Category getCategoryByCategoryNameEng(@Param("categoryNameEng") String categoryNameEng);

}
