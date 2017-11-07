package com.gokhantamkoc.spring.boot.redis.example.repository;


import com.gokhantamkoc.spring.boot.redis.example.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductRepository extends CrudRepository<Product, String> {
}
