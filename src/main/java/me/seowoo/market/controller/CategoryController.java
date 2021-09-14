package me.seowoo.market.controller;

import me.seowoo.market.dto.CategoryDto;
import me.seowoo.market.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getCategory() {
        return ResponseEntity.ok(categoryService.getCategory());
    }
}
