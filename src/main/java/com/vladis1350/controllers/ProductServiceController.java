package com.vladis1350.controllers;

import com.vladis1350.bean.Category;
import com.vladis1350.bean.Product;
import com.vladis1350.constant.EntityConstant;
import com.vladis1350.constant.Pages;
import com.vladis1350.constant.Http;
import com.vladis1350.services.CategoryService;
import com.vladis1350.services.ProductService;
import com.vladis1350.validate.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = Http.HOME, method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute(EntityConstant.PRODUCTS, products);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }

    @RequestMapping(value = Http.NEW_CATEGORY, method = RequestMethod.GET)
    public String showNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        model.addAttribute(EntityConstant.UNIT_CATEGORY, category);
        return Pages.CATEGORY;
    }

    @RequestMapping(value = Http.NEW_PRODUCT, method = RequestMethod.GET)
    public String showNewProductsForm(Model model) {
        Product product = new Product();
        model.addAttribute(EntityConstant.UNIT_PRODUCT, product);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.NEW_PRODUCT;
    }

    @RequestMapping(value = Http.EDIT_PRODUCT+"/{id}", method = RequestMethod.GET)
    public ModelAndView showEditProductsForm(@PathVariable(name = "id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView(Pages.EDIT_PRODUCT);
        Product product = productService.getById(id);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        modelAndView.addObject(EntityConstant.UNIT_PRODUCT, product);
        return modelAndView;
    }


    @RequestMapping(value = Http.SAVE_CATEGORY, method = RequestMethod.POST)
    public String showCategory(@ModelAttribute(EntityConstant.UNIT_CATEGORY) Category category, Model model) {
        categoryService.save(category);

        return showNewCategoryForm(model);
    }

    @RequestMapping(value = Http.SAVE_PRODUCT, method = RequestMethod.POST)
    public String showProduct(@ModelAttribute(EntityConstant.UNIT_PRODUCT) Product product, Model model) {
        if (ProductValidator.checkValidateDataProduct(product)) {
            productService.save(product);
        } else {
            return Pages.ERROR;
        }
        return Pages.REDIRECT+Pages.HOME;
    }

    @RequestMapping(value = Http.CANCEL, method = RequestMethod.POST)
    public String clearFilterAndSearch() {
        return Pages.REDIRECT+Pages.HOME;
    }

    @RequestMapping(value = Http.SEARCH, method = RequestMethod.POST)
    public String searchProductById(@ModelAttribute(EntityConstant.UNIT_PRODUCT) Product product, Model model) {
        Product product1 = productService.getById(product.getId());
        System.out.println(product.getCategory());
        model.addAttribute(EntityConstant.PRODUCTS, product1);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        return Pages.HOME;
    }

    @RequestMapping(value = Http.FILTER, method = RequestMethod.POST)
    public String filterProductByCategory(@ModelAttribute(EntityConstant.UNIT_CATEGORY) String category, Model model) {
        List<Product> productList = productService.findAllByCategory(category);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        return Pages.HOME;
    }

    @RequestMapping(value = Http.DELETE_PRODUCT+"/{id}", method = RequestMethod.GET)
    public String deleteProducts(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return Pages.REDIRECT+Pages.HOME;
    }

    @RequestMapping("/set")
    public String showSetDiscountForm(Model model) {
        Product product = new Product();
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        model.addAttribute(EntityConstant.PRODUCTS, product);

        return Pages.SET_DISCOUNT;
    }

    @RequestMapping(value = "/setDiscount", method = RequestMethod.POST)
    public String setDiscountForCategory(@ModelAttribute(EntityConstant.UNIT_PRODUCT) Product product, BigDecimal discount, Model model) {
        productService.setDiscountForCategory(product.getCategory(), discount);
        return Pages.REDIRECT;
    }

}
