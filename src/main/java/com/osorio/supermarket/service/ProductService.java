package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<ProductResponse> getAllProducts();

    public ProductResponse saveProduct(ProductRequest productRequest);

    public void deleteProductById(int productId);

    public ProductResponse updateProductById(ProductRequest productRequest, int productId);

    public Optional<ProductResponse> getProductById(int productId);
}
