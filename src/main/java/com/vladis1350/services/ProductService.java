package com.vladis1350.services;

import com.vladis1350.bean.Category;
import com.vladis1350.bean.Product;
import com.vladis1350.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    Logger log = LogManager.getLogger(Product.class);

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    public boolean addNewProduct(Product product) {
        if (product.getName() == null) {
            return false;
        }
        repository.save(product);
        return true;
    }

    public Product getById(Long id) {
        log.info("Accepted " + id);
        Optional<Product> value = repository.findById(id);
        log.info("Get optional value: " + value);
        return value.orElseGet(() -> value.orElse(new Product()));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Product> findAllByCategory(String category) {
        Iterable<Product> products = repository.findAll();
        List<Product> resultFilter = new ArrayList<>();
        for (Product product: products) {
            if (product.getCategory().equals(category)) {
                resultFilter.add(product);
            }
        }
        return resultFilter;
    }

    public void setDiscountForCategory(String category, BigDecimal discount) {
        Iterable<Product> products = repository.findAll();
        List<Product> resultList = new ArrayList<>();

        for (Product product: products) {
            if (product.getCategory().equals(category)) {
                product.setDiscount(discount);
                resultList.add(product);
            }
        }
        repository.saveAll(resultList);
    }
}
