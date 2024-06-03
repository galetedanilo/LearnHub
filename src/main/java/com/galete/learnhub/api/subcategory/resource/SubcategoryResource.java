package com.galete.learnhub.api.subcategory.resource;

import com.galete.learnhub.api.subcategory.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryResource extends JpaRepository<Subcategory, Long> {
}
