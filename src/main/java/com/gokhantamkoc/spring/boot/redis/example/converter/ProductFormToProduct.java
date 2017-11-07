package com.gokhantamkoc.spring.boot.redis.example.converter;

import com.gokhantamkoc.spring.boot.redis.example.commands.ProductForm;
import com.gokhantamkoc.spring.boot.redis.example.model.Product;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author gokhantamkoc
 * @version 2017-11-08
 */

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        if (productForm.getId() != null  && !StringUtils.isEmpty(productForm.getId())) {
            product.setId(productForm.getId());
        }
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());
        return product;
    }
}
