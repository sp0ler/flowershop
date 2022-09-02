package ru.deevdenis.flowershop.servises;

import ru.deevdenis.flowershop.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    void saveCategory(Category category);

    Category getCategory(int id);

    void deleteCategory(int id);


    Category getCategoryByCategoryNameEng(String categoryNameEng);
}
