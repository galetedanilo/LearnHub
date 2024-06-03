package com.galete.learnhub.api.category.resource;

import com.galete.learnhub.api.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryResource extends JpaRepository<Category, Long> {
}
