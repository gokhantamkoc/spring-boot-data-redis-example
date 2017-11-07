package com.gokhantamkoc.spring.boot.redis.example.service;

import com.gokhantamkoc.spring.boot.redis.example.commands.ProductForm;
import com.gokhantamkoc.spring.boot.redis.example.converter.ProductFormToProduct;
import com.gokhantamkoc.spring.boot.redis.example.model.Product;
import com.gokhantamkoc.spring.boot.redis.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gokhantamkoc
 * @version 2017-11-08
 */

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductFormToProduct productFormToProduct;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
    }


    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);

    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));
        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
