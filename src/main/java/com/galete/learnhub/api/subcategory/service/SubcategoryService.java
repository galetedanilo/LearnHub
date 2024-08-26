package com.galete.learnhub.api.subcategory.service;

import com.galete.learnhub.api.category.service.CategoryService;
import com.galete.learnhub.api.subcategory.dto.request.SubcategoryRequest;
import com.galete.learnhub.api.subcategory.entity.Subcategory;
import com.galete.learnhub.api.subcategory.mapper.SubcategoryMapper;
import com.galete.learnhub.api.subcategory.resource.SubcategoryRepository;
import com.galete.learnhub.exception.ResourceNotFound;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private final CategoryService categoryService;
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;

    @Transactional
    public Subcategory create(Subcategory subcategory) {
        categoryService.findById(subcategory.getCategory().getId());
        return this.subcategoryRepository.save(subcategory);

    }

    public Subcategory findById(Long id) {
        return this.subcategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Subcategory with id: " + id + " is not found"));
    }

    public Page<Subcategory> findAll(Pageable pageable) {
        return subcategoryRepository.findAll(pageable);
    }

    public List<Subcategory> findByCategoryId(Long categoryId) {
        return this.subcategoryRepository.findByCategoryId(categoryId);
    }

    @Transactional
    public Subcategory update(Long id, SubcategoryRequest subcategoryRequest) {
        Subcategory category = findById(id);

        subcategoryMapper.updateSubcategoryRequestToSubcategory(subcategoryRequest, category);

        return this.subcategoryRepository.save(category);
    }


    public void remove(Long id) {
        findById(id);

        subcategoryRepository.deleteById(id);
    }
}
