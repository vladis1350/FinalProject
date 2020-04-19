package com.vladis1350.services;

import com.vladis1350.bean.Category;
import com.vladis1350.repositories.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    Logger log = LogManager.getLogger(Category.class);

    @BeforeEach
    void setUp() {
    }

    @Test
    void testShouldSaveNewCategory() {
        Category categoryNotEmpty = new Category("New category for testing");
        Category EmptyCategory = new Category();
        boolean isCategoryCreated = categoryService.addNewCategory(categoryNotEmpty);
        boolean isCategoryNotCreated = categoryService.addNewCategory(EmptyCategory);

        Assert.assertTrue(isCategoryCreated);
        Assert.assertFalse(isCategoryNotCreated);
    }

    @Test
    void testShouldReturnId() {
        Category actualCategory = categoryService.getById(2L);
        log.info(actualCategory);

        long actualId = actualCategory.getId();
        log.info(actualId);

        Assert.assertEquals(2L, actualId);
    }

    @Test
    void testShouldReturnNameCategory() {
        Category category = new Category("categoryTest");
        String actualCategoryName = category.getNameCategory();

        Assert.assertEquals("categoryTest", actualCategoryName);
    }

    @Test
    void testShouldRenameCategory() {
        Category category = new Category("categoryTest");
        category.setNameCategory("testCategory");
        String actualCategoryName = category.getNameCategory();

        Assert.assertEquals("testCategory", actualCategoryName);
    }
}