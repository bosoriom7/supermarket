package com.osorio.supermarket.service;

import com.osorio.supermarket.controller.entity.Product;
import com.osorio.supermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Inyectando el repositorio en el servicio
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(int productId){
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.deleteById(productId);
        }
    }

    public Product updateProductById(Product product, int productId){
        Optional<Product> productToUpdate = productRepository.findById(productId);
        if (productToUpdate.isPresent()) {
            product.setProductId(productId);
            product = productRepository.save(product);
        }return product;
    }

    public Optional<Product> getProductById(int productId){
        return productRepository.findById(productId);
    }

}
