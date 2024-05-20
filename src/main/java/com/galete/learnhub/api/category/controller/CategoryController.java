package com.galete.learnhub.api.category.controller;

import com.galete.learnhub.api.category.dto.requests.CategoryRequest;
import com.galete.learnhub.api.category.dto.responses.CategoryResponse;
import com.galete.learnhub.api.category.entity.Category;
import com.galete.learnhub.api.category.mapper.CategoryMapper;
import com.galete.learnhub.api.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        category = categoryService.create(category);

        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);

        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);

        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<CategoryResponse>> findAll(Pageable pageable) {
        Page<Category> category = categoryService.findAll(pageable);

        Page<CategoryResponse> categoryResponses = category.map(categoryMapper::categoryToCategoryResponse);

        return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);

        category = categoryService.update(id, category);

        CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
