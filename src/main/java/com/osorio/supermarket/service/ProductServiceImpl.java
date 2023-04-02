package com.osorio.supermarket.service;

import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.entity.Product;
import com.osorio.supermarket.exception.ProductNoFoundException;
import com.osorio.supermarket.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest){
        double priceSelf = (productRequest.getPricePurchase() * 0.5) + productRequest.getPricePurchase();
        Product product = new Product(0, productRequest.getName(), productRequest.getQuantity(), productRequest.getPricePurchase(), priceSelf);
        Product productSave = productRepository.save(product);
        return new ProductResponse(productSave.getName(), productSave.getQuantity(), productSave.getPriceSelf());
    }

    @Override
    public void deleteProductById(int productId){
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.deleteById(productId);
        }else{
            throw new ProductNoFoundException("Producto con Id: " + productId + " no encontrado");
        }
    }

    @Override
    public Product updateProductById(Product product, int productId){
        Optional<Product> productToUpdate = productRepository.findById(productId);
        if (productToUpdate.isPresent()) {
            product.setProductId(productId);
            product = productRepository.save(product);
        }return product;
    }

    @Override
    public Optional<Product> getProductById(int productId){
        return productRepository.findById(productId);
    }

}