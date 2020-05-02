package com.chubb.warehouse.repository;

import com.chubb.warehouse.entity.Product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Product findByItemNo(Long id);
}
