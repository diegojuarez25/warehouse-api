package com.chubb.warehouse.service.impl;

import com.chubb.warehouse.entity.Product;
import com.chubb.warehouse.repository.ProductRepository;
import com.chubb.warehouse.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findByItemNo(id);
    }

    @Override
    public Product createOrUpdateProduct(Product entity) {
        Product product = repository.findByItemNo(entity.getItemNo());

        if (!isEmpty(product)) {
            entity.setItemNo(product.getItemNo());
        }

        return repository.save(entity);
    }

    @Override
    public void deleteProductById(Long id) throws Exception {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        }

        throw new Exception("Producto no existe");
    }
}
