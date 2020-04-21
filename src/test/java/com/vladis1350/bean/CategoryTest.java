package com.vladis1350.bean;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testEquals() {
        Category categoryOne = new Category("test category");
        Category categoryTwo = new Category("test categories");
        Category categoryThree = categoryOne;

        boolean actualResultShouldBeFalse = categoryOne.equals(categoryTwo);

        Assert.assertFalse(actualResultShouldBeFalse);
    }

    @Test
    void testHashCode() {
        Category categoryOne = new Category("test category");
        Category categoryTwo = new Category("test categories");

        Assert.assertFalse(categoryOne.hashCode() == categoryTwo.hashCode());
        Assert.assertTrue(categoryOne.hashCode() != categoryTwo.hashCode());
    }
}