package com.vladis1350.controllers;

import com.vladis1350.bean.Product;
import com.vladis1350.constant.EntityConstant;
import com.vladis1350.constant.Http;
import com.vladis1350.constant.Pages;
import com.vladis1350.constant.SortingOptions;
import com.vladis1350.services.CategoryService;
import com.vladis1350.services.ProductComparatorService;
import com.vladis1350.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductSortController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = Http.SORTING_NAME)
    public String sortingProductsByName(@ModelAttribute("sortByName") String variable, Model model) {
        Iterable<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);
        if (variable.equals(SortingOptions.ORDER_NAME)) {
            productList.sort(ProductComparatorService.compareOrderName);
        } else if (variable.equals(SortingOptions.REVERSE_ORDER_NAME)) {
            productList.sort(ProductComparatorService.compareReverseOrderName);
        }
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }

    @PostMapping(value = Http.SORTING_PRICE)
    public String sortingProductsByPrice(@ModelAttribute("sortByPrice") String variable, Model model) {
        Iterable<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);
        if (variable.equals(SortingOptions.ORDER_PRICE)) {
            productList.sort(ProductComparatorService.compareOrderPrice);
        } else if (variable.equals(SortingOptions.REVERSE_ORDER_PRICE)){
            productList.sort(ProductComparatorService.compareReverseOrderPrice);
        }
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }

    @PostMapping(value = Http.SORTING_CATEGORY)
    public String sortingProductsByCategory(@ModelAttribute("sortByCategory") String variable, Model model) {
        Iterable<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);
        if (variable.equals(SortingOptions.ORDER_CATEGORY)) {
            productList.sort(ProductComparatorService.compareOrderCategory);
        } else if (variable.equals(SortingOptions.REVERSE_ORDER_CATEGORY)){
            productList.sort(ProductComparatorService.compareReverseOrderCategory);
        }
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }

    @PostMapping(value = Http.SORTING_DISCOUNT)
    public String sortingProductsByDiscount(@ModelAttribute("sortByDiscount") String variable, Model model) {
        Iterable<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);
        if (variable.equals(SortingOptions.ORDER_DISCOUNT)) {
            productList.sort(ProductComparatorService.compareOrderDiscount);
        } else if (variable.equals(SortingOptions.REVERSE_ORDER_DISCOUNT)){
            productList.sort(ProductComparatorService.compareReverseOrderDiscount);
        }
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }
}
