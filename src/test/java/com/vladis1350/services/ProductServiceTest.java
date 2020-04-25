package com.vladis1350.services;

import com.vladis1350.bean.Product;
import com.vladis1350.repositories.ProductRepository;
import org.apache.logging.log4j.Level;
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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    Logger log = LogManager.getLogger(Product.class);

    @BeforeEach
    void setUp() {
    }

    @Test
    void testShouldSaveNewProduct() {
        Product productNotEmpty =
                new Product("New product for testing", BigDecimal.valueOf(14.2), "test category", BigDecimal.valueOf(20));
        Product EmptyProduct = new Product();
        boolean isProductCreated = productService.addNewProduct(productNotEmpty);
        boolean isProductNotCreated = productService.addNewProduct(EmptyProduct);

        Assert.assertTrue(isProductCreated);
        Assert.assertFalse(isProductNotCreated);
    }

    @Test
    void getById() {
        Product product = productService.getById(3L);
        log.info(product);

        long actualId = product.getId();
        log.info(actualId);

        Assert.assertEquals(3L, actualId);
    }

    @Test
    void deleteById() {
        Product product = productService.getById(3L);
        log.log(Level.INFO, product);

        productService.deleteById(3L);
        Product actualResultDeleted = productService.getById(3L);
        log.log(Level.INFO, product);

        Assert.assertEquals(new Product(), actualResultDeleted);
    }

    @Test
    void findAllByCategory() {
        productService.addNewProduct(new Product("asd", BigDecimal.valueOf(11), "Building products", BigDecimal.valueOf(1)));
        Iterable<Product> resultList = productService.findAllByCategory("Building products");
        int actualResult = 0;
        Iterator iterator = resultList.iterator();
        while (iterator.hasNext()){
            iterator.next();
            actualResult++;
        }
        Assert.assertEquals(2, actualResult);
    }

    @Test
    void findAll() {
        Iterable<Product> allList = productService.findAll();
        log.info(allList);
        int actualResult = 0;
        Iterator iterator = allList.iterator();
        while (iterator.hasNext()){
            iterator.next();
            actualResult++;
        }
        Assert.assertEquals(6, actualResult);
    }

    @Test
    void setDiscountForCategory() {
        productService.setDiscountForCategory("Fruit", BigDecimal.valueOf(33));

    }
}