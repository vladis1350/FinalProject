package com.vladis1350.controllers;

import com.vladis1350.bean.Category;
import com.vladis1350.constant.EntityConstant;
import com.vladis1350.constant.Http;
import com.vladis1350.constant.Pages;
import com.vladis1350.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryServiceController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = Http.NEW_CATEGORY)
    public String showNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        model.addAttribute(EntityConstant.UNIT_CATEGORY, category);
        return Pages.CATEGORY;
    }

    @PostMapping(value = Http.SAVE_CATEGORY)
    public String showCategory(@ModelAttribute Category category, Model model) {
        categoryService.addNewCategory(category);

        return showNewCategoryForm(model);
    }
}
