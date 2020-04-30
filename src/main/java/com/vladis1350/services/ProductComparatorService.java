package com.vladis1350.services;

import com.vladis1350.bean.Product;

import java.util.Comparator;

public class ProductComparatorService {
    public static Comparator<Product> compareOrderName = (product1, product2) -> {
        if ((Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) == 0) {
            return product1.getName().compareTo(product2.getName()) * -1;
        }
        return product1.getName().compareTo(product2.getName());
    };

    public static Comparator<Product> compareReverseOrderName = (product1, product2) -> {
        if ((Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) == 0) {
            return product1.getName().compareTo(product2.getName());
        }
        return product1.getName().compareTo(product2.getName()) * -1;
    };

    public static Comparator<Product> compareOrderCategory = (product1, product2) -> {
        if ((Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) == 0) {
            return product1.getCategory().compareTo(product2.getCategory()) * -1;
        }
        return product1.getCategory().compareTo(product2.getCategory());
    };

    public static Comparator<Product> compareReverseOrderCategory = (product1, product2) -> {
        if ((Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) == 0) {
            return product1.getCategory().compareTo(product2.getCategory());
        }
        return product1.getCategory().compareTo(product2.getCategory()) * -1;
    };

    public static Comparator<Product> compareOrderPrice = (product1, product2) -> {
        return (int) (Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString()));
    };

    public static Comparator<Product> compareReverseOrderPrice = (product1, product2) -> {
        return (int) (Double.parseDouble(product1.getPrice().toString()) - Double.parseDouble(product2.getPrice().toString())) * -1;
    };

    public static Comparator<Product> compareOrderDiscount = (product1, product2) -> {
        return (int) (Double.parseDouble(product1.getDiscount().toString()) - Double.parseDouble(product2.getDiscount().toString()));
    };

    public static Comparator<Product> compareReverseOrderDiscount = (product1, product2) -> {
        return (int) (Double.parseDouble(product1.getDiscount().toString()) - Double.parseDouble(product2.getDiscount().toString())) * -1;
    };
}
