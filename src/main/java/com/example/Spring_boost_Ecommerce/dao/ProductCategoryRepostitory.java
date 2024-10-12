package com.example.Spring_boost_Ecommerce.dao;

import com.example.Spring_boost_Ecommerce.Entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product-category")
public interface ProductCategoryRepostitory extends JpaRepository<ProductCategory,Long> {
}
