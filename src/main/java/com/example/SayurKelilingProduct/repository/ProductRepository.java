package com.example.SayurKelilingProduct.repository;

import com.example.SayurKelilingProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>,ProductRepositoryCustom {
}
