package com.osorio.supermarket.mapper;

import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.entity.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<ProductRequest, Product> {
    @Override
    public Product apply(ProductRequest productRequest) {
        double priceSelf = (productRequest.getPricePurchase() * 0.5) + productRequest.getPricePurchase();
        return new Product(
                productRequest.getProductId(), productRequest.getName(), productRequest.getQuantity(), productRequest.getPricePurchase(), priceSelf
        );
    }
}
