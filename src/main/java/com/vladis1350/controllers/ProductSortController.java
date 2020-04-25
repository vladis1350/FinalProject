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
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping(value = Http.SORTING)
    public String sortingProducts(@ModelAttribute("sortVariables") String variable, Model model) {
        Iterable<Product> products = productService.findAll();
        List<Product> productList = new ArrayList<>();
        products.forEach(productList::add);
        if (variable.equals(SortingOptions.BY_NAME)) {
            productList.sort(ProductComparatorService.compareProductName);
        } else if (variable.equals(SortingOptions.BY_CATEGORY)) {
            productList.sort(ProductComparatorService.compareCategory);
        } else if (variable.equals(SortingOptions.BY_PRICE)) {
            productList.sort(ProductComparatorService.comparePrice);
        } else {
            productList.sort(ProductComparatorService.compareDiscount);
        }
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }
}
