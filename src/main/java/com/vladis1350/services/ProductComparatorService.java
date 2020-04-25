package com.vladis1350.services;

import com.vladis1350.bean.Product;

import java.util.Comparator;

public class ProductComparatorService {
    public static Comparator<Product> compareProductName = (product1, product2) -> {
        if ((Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) == 0) {
            return product1.getName().compareTo(product2.getName()) * -1;
        }
        return product1.getName().compareTo(product2.getName());
    };

    public static Comparator<Product> compareCategory = (product1, product2) -> {
        if ((Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) == 0) {
            return product1.getCategory().compareTo(product2.getCategory()) * -1;
        }
        return product1.getCategory().compareTo(product2.getCategory());
    };

    public static Comparator<Product> comparePrice = (product1, product2) -> {
        return (int) (Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString()));
    };

    public static Comparator<Product> compareDiscount = (product1, product2) -> {
        return (int) (Double.parseDouble(product1.getDiscount().toString()) - Double.parseDouble(product2.getDiscount().toString()));
    };
}
