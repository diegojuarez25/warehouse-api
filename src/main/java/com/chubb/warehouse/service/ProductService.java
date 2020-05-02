package com.chubb.warehouse.service;

import com.chubb.warehouse.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product getProductById(Long id);
    Product createOrUpdateProduct(Product entity);
    void deleteProductById(Long id) throws Exception;

}
