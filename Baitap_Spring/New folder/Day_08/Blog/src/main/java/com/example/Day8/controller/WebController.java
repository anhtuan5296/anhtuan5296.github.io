package com.example.Day8.controller;

import com.example.Day8.entity.Blog;
import com.example.Day8.service.BlogService;
import com.example.Day8.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class WebController {
    private final BlogService blogService;
    private final CategoryService categoryService;
    @GetMapping("/")
    public String getHome(Model model) {
        Page<Blog> pageData = blogService.findAll(1, 5);
        model.addAttribute("currentPage", 1);
        model.addAttribute("pageData", pageData);
        return "main";
    }

    @GetMapping("/page/{pageNumber}")
    public String getPage(Model model, @PathVariable Integer pageNumber) {
        Page<Blog> pageData = blogService.findAll(pageNumber, 5);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageData", pageData);
        return "page";
    }

    @GetMapping("search")
    public String searchBlog() {
        return null;
    }

    @GetMapping("categories")
    public String getAllCategory() {
        return null;
    }

    @GetMapping("categories/{categoryName}")
    public String getBlogsOfCategory() {
        return null;
    }

    @GetMapping("blogs/{blogId}/{blogSlug}")
    public String getBlogDetail() {
        return null;
    }

}
