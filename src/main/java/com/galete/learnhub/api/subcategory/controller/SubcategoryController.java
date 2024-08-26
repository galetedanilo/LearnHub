package com.galete.learnhub.api.subcategory.controller;

import com.galete.learnhub.api.subcategory.dto.request.SubcategoryRequest;
import com.galete.learnhub.api.subcategory.dto.response.SubcategoryResponse;
import com.galete.learnhub.api.subcategory.entity.Subcategory;
import com.galete.learnhub.api.subcategory.mapper.SubcategoryMapper;
import com.galete.learnhub.api.subcategory.service.SubcategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subcategories")
@RequiredArgsConstructor
public class SubcategoryController {
    private final SubcategoryService subcategoryService;
    private final SubcategoryMapper subcategoryMapper;

    @PostMapping
    public ResponseEntity<SubcategoryResponse> createSubcategory(@Valid @RequestBody SubcategoryRequest subcategoryRequest) {
        Subcategory subcategory = subcategoryMapper.toEntity(subcategoryRequest);

        subcategory = subcategoryService.create(subcategory);

        SubcategoryResponse subcategoryResponse = subcategoryMapper.toDTO(subcategory);

        return new ResponseEntity<>(subcategoryResponse, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubcategoryResponse> findSubcategoryById(@PathVariable Long id) {
        Subcategory subcategory = subcategoryService.findById(id);

        SubcategoryResponse subcategoryResponse = subcategoryMapper.toDTO(subcategory);

        return new ResponseEntity<>(subcategoryResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<SubcategoryResponse>> findAllSubcategories(Pageable pageable) {
        Page<Subcategory> subcategoryPage = subcategoryService.findAll(pageable);

        Page<SubcategoryResponse> subcategoryResponsePage = subcategoryPage.map(subcategoryMapper::toDTO);

        return new ResponseEntity<>(subcategoryResponsePage, HttpStatus.OK);
    }

    @GetMapping("category/{categoryId}/list")
    public ResponseEntity<List<SubcategoryResponse>>findSubcategoryByCategoryId(@PathVariable Long categoryId) {
        List<Subcategory> subcategories = subcategoryService.findByCategoryId(categoryId);

        List<SubcategoryResponse> subcategoryResponse = subcategoryMapper.toDTO(subcategories);

        return new ResponseEntity<>( subcategoryMapper.toDTO(subcategories), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<SubcategoryResponse> updateSubcategory(@PathVariable Long id, @Valid @RequestBody SubcategoryRequest subcategoryRequest) {
        Subcategory subcategory = subcategoryService.update(id, subcategoryRequest);

        SubcategoryResponse subcategoryResponse = subcategoryMapper.toDTO(subcategory);

        return new ResponseEntity<>(subcategoryResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable Long id) {
        subcategoryService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
