package com.galete.learnhub.api.category.service;

import com.galete.learnhub.api.category.dto.request.CategoryRequest;
import com.galete.learnhub.api.category.entity.Category;
import com.galete.learnhub.api.category.mapper.CategoryMapper;
import com.galete.learnhub.api.category.repository.CategoryRepository;
import com.galete.learnhub.exception.ResourceNotFound;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category findById(Long id) {

        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category with id: " + id + " is not found"));

    }

    public Page<Category> findAll(Pageable pageable) {

        return categoryRepository.findAll(pageable);
    }

    public Category update(Long id, CategoryRequest categoryRequest) {
        Category category = findById(id);

        categoryMapper.updateCategoryRequestFromCategory(categoryRequest, category);

        return this.categoryRepository.save(category);
    }

    public void remove(Long id) {
        findById(id);

        categoryRepository.deleteById(id);
    }
}
