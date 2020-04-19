package com.vladis1350.services;

import com.vladis1350.bean.Category;
import com.vladis1350.repositories.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    Logger log = LogManager.getLogger(CategoryService.class);

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public boolean addNewCategory(Category category) {
        if (category.getNameCategory() == null) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    public Category getById(Long id) {
        Optional<Category> value = categoryRepository.findById(id);
        if (!value.isPresent()) {
            log.warn("id category not found!");
        }
        return value.orElseGet(() -> value.orElse(new Category()));
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
