package com.chubb.warehouse.controller;

import com.chubb.warehouse.dto.ResponseProductList;
import com.chubb.warehouse.entity.Product;
import com.chubb.warehouse.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/products")
@Api(value = "Warehouse api", description = "This API has a endpoints for product warehouse")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "get products")
    @GetMapping
    public ResponseProductList getProducts() {

        ResponseProductList response = new ResponseProductList();
         try {
            List<Product> products = productService.findAll();
            response.setProducts(products);
            response.setCode(200);
            response.setMessage("exito");
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @ApiOperation(value = "get product by Id")
    @GetMapping("/{id}")
    public ResponseProductList getProductById(@PathVariable("id") Long id) {
        ResponseProductList response = new ResponseProductList();
        Product entity = productService.getProductById(id);
        response.setProducts(Collections.singletonList(entity));
        response.setMessage("exito");
        response.setCode(200);
        return response;
    }

    @ApiOperation(value = "create or update product")
    @PostMapping
    public ResponseProductList createOrUpdateProduct(@RequestBody Product product) {
        ResponseProductList response = new ResponseProductList();
        Product updated = productService.createOrUpdateProduct(product);
        response.setProducts(Collections.singletonList(updated));
        response.setMessage("exito");
        response.setCode(200);
        return response;
    }

    @ApiOperation(value = "delete product")
    @DeleteMapping("/{itemNo}")
    public ResponseProductList deleteProductById(@PathVariable("itemNo") Long id) {
        ResponseProductList response = new ResponseProductList();
        try {
            productService.deleteProductById(id);
            response.setMessage("exito");
            response.setCode(200);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setCode(500);
        }

        return response;
    }
}
