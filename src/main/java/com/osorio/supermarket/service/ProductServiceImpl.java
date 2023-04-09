package com.osorio.supermarket.service;
import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.entity.Product;
import com.osorio.supermarket.exception.ProductNotFoundException;
import com.osorio.supermarket.mapper.ProductMapper;
import com.osorio.supermarket.mapper.ProductResponseMapper;
import com.osorio.supermarket.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final String PRODUCT_NOT_FOUND_MESSAGE = "Producto no encontrado";
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductResponseMapper productResponseMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(productResponseMapper).toList();
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest){
        Product product = productMapper.apply(productRequest);
        Product productSave = productRepository.save(product);
        return productResponseMapper.apply(productSave);
    }

    @Override
    public void deleteProductById(int productId){
        productRepository.findById(productId)
                .ifPresent(existingProduct -> productRepository.deleteById(productId));
    }

    @Override
    public ProductResponse updateProductById(ProductRequest productRequest) {
        Product product = productMapper.apply(productRequest);
        return productRepository.findById(product.getProductId())
                .map(existingProduct -> productRepository.save(product))
                .map(productResponseMapper)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE));
    }

    @Override
    public Optional<ProductResponse> getProductById(int productId) {
        return productRepository.findById(productId)
                .map(productResponseMapper)
                .or(() -> { throw new ProductNotFoundException(PRODUCT_NOT_FOUND_MESSAGE); });
    }
}