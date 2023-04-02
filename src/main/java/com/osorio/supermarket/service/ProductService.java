package com.osorio.supermarket.service;

import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();

    public ProductResponse saveProduct(ProductRequest productRequest);

    public void deleteProductById(int productId);

    public Product updateProductById(Product product, int productId);

    public Optional<Product> getProductById(int productId);
}
