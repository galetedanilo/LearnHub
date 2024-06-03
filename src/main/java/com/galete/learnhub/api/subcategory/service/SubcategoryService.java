package com.galete.learnhub.api.subcategory.service;

import com.galete.learnhub.api.subcategory.dto.request.SubcategoryRequest;
import com.galete.learnhub.api.subcategory.entity.Subcategory;
import com.galete.learnhub.api.subcategory.mapper.SubcategoryMapper;
import com.galete.learnhub.api.subcategory.resource.SubcategoryResource;
import com.galete.learnhub.exception.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private SubcategoryResource subcategoryResource;
    private SubcategoryMapper subcategoryMapper;

    public Subcategory create(Subcategory subcategory) {
        return this.subcategoryResource.save(subcategory);
    }

    public Subcategory findById(Long id) {
        return this.subcategoryResource.findById(id).orElseThrow(() -> new ResourceNotFound("Subategory with id: " + id + " is not found"));
    }

    public Subcategory update(Long id, SubcategoryRequest subcategoryRequest) {
        Subcategory category = findById(id);

        subcategoryMapper.updateSubcategoryRequestToSubcategory(subcategoryRequest, category);

        return this.subcategoryResource.save(category);
    }


    public void remove(Long id) {
        findById(id);

        subcategoryResource.deleteById(id);
    }
}
