package com.gokhantamkoc.spring.boot.redis.example.service;

import com.gokhantamkoc.spring.boot.redis.example.commands.ProductForm;
import com.gokhantamkoc.spring.boot.redis.example.model.Product;

import java.util.List;

/**
 * @author gokhantamkoc
 * @version 2017-11-08
 */

public interface ProductService {

    List<Product> listAll();

    Product getById(String id);

    Product saveOrUpdate(Product product);

    void delete(String id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
