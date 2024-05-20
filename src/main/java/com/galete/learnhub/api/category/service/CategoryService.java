package com.galete.learnhub.api.category.service;

import com.galete.learnhub.api.category.entity.Category;
import com.galete.learnhub.api.category.resouce.CategoryResource;
import com.galete.learnhub.exception.ResourceNotFound;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryResource categoryResource;

    public Category create(Category category) {

        final LocalDateTime localDateTime = LocalDateTime.now();

        category.setCreatedAt(localDateTime);
        category.setUpdatedAt(localDateTime);

        return this.categoryResource.save(category);

    }

    public Category findById(Long id) {

        return this.categoryResource.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category with id: " + id + " is not found"));

    }

    public Page<Category> findAll(Pageable pageable) {

        return categoryResource.findAll(pageable);
    }

    public Category update(Long id, Category category) {
        Category updatedCategory = findById(id);

        updatedCategory.setName(category.getName());
        updatedCategory.setDescription(category.getDescription());
        updatedCategory.setActive(category.getActive());
        updatedCategory.setUpdatedAt(LocalDateTime.now());

        return this.categoryResource.save(category);


    }


    public void remove(Long id) {
        findById(id);

        categoryResource.deleteById(id);

    }

}
