package com.osorio.supermarket.controller;
import com.osorio.supermarket.dto.request.ProductRequest;
import com.osorio.supermarket.dto.response.ProductResponse;
import com.osorio.supermarket.entity.Product;
import com.osorio.supermarket.exception.ProductNoFoundException;
import com.osorio.supermarket.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Optional<Product>>getProductById(@PathVariable("product-id")int productId){
       return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest productRequest){
        return new ResponseEntity<>(productService.saveProduct(productRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void>deleteProductBId(@PathVariable("product-id") int productId){
        try{
            productService.deleteProductById(productId);
        }catch (ProductNoFoundException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<Product> updateProductById(@RequestBody @Valid Product product, @PathVariable("product-id") int productId){
        return  new ResponseEntity<>(productService.updateProductById(product, productId), HttpStatus.OK);
    }

}
