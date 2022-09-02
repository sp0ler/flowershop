package ru.deevdenis.flowershop.servises.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deevdenis.flowershop.DAO.CategoryDAO;
import ru.deevdenis.flowershop.models.Category;
import ru.deevdenis.flowershop.servises.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getAllCategory() {
        return categoryDAO.findAll();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @Transactional
    public Category getCategory(int id) {
        return categoryDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public Category getCategoryByCategoryNameEng(String categoryNameEng) {
        return categoryDAO.getCategoryByCategoryNameEng(categoryNameEng);
    }
}
