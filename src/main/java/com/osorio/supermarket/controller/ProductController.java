package com.osorio.supermarket.controller;
import com.osorio.supermarket.controller.entity.Product;
import com.osorio.supermarket.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//No se deben importar librerias que terminen en *
//import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Inyectando el servicio al controller
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Optional<Product>>getProductById(@PathVariable("product-id")int productId){
       return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping
    //@Valid sirve para condicionar a que los datos que se envien no sean null
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void>deleteProductBId(@PathVariable("product-id") int productId){
        System.out.println(productId);
        productService.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<Product> updateProductById(@RequestBody @Valid Product product, @PathVariable("product-id") int productId){
        return  new ResponseEntity<>(productService.updateProductById(product, productId), HttpStatus.OK);
    }
}
