package com.example.spring_crud.services;

import com.example.spring_crud.entities.Product;
import com.example.spring_crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return  productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Optional <Product> update(Long id, Product product) {
        Optional <Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product productDb = productOptional.orElseThrow();
           productDb.setName(product.getName());
           productDb.setPrice(product.getPrice());
            productDb.setDescription(product.getDescription());
            return Optional.of(productRepository.save(productDb));
        }
        return productOptional;
    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional <Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent( productDb -> productRepository.delete(productDb));
    return productOptional;
    }
}
