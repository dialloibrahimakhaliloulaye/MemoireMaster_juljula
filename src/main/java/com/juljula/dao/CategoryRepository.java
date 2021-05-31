package com.juljula.dao;

import com.juljula.entities.Category;
import com.juljula.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
