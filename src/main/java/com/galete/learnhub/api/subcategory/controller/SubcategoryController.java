package com.galete.learnhub.api.subcategory.controller;

import com.galete.learnhub.api.subcategory.dto.request.SubcategoryRequest;
import com.galete.learnhub.api.subcategory.dto.response.SubcategoryResponse;
import com.galete.learnhub.api.subcategory.entity.Subcategory;
import com.galete.learnhub.api.subcategory.mapper.SubcategoryMapper;
import com.galete.learnhub.api.subcategory.service.SubcategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subcategory")
@RequiredArgsConstructor
public class SubcategoryController {
    private SubcategoryService subcategoryService;
    private SubcategoryMapper subcategoryMapper;

//    @PostMapping
//    public ResponseEntity<SubcategoryResponse> createSubcategory(@Valid @RequestBody SubcategoryRequest subcategoryRequest) {
//        Subcategory subcategory = subcategoryMapper.toEntity(subcategoryRequest);
//
//        subcategory = subcategoryService.create(subcategory);
//
//
//    }
}
