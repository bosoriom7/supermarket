package com.osorio.supermarket.mapper;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.entity.Product;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class ProductResponseMapper implements Function<Product, ProductResponse> {
    @Override
    public ProductResponse apply(Product product) {
        return new ProductResponse(product.getProductId(), product.getName(), product.getQuantity(), product.getPriceSelf());
    }
}
