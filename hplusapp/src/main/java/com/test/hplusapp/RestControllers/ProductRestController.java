package com.test.hplusapp.RestControllers;

import com.test.hplusapp.Entity.Product;
import com.test.hplusapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Controller
@RestController // do need to mention @ResponseBody with every method inside this
public class ProductRestController {

    ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*

    @GetMapping("/hplus/rest/products/")
    @ResponseBody // it tells the spring that the data returned by method should be a response body and convert that data to JSON.
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

//      can do like this-
//        Iterable<Product> list = this.productRepository.findAll();
//        for(Product p : list){
//            products.add(p);
//        }

//      or you can do like this-
        this.productRepository.findAll().forEach(product -> {products.add(product);});

        return products;
    }

     */


    @GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByName(@RequestParam("name")String name){
        List<Product> products = this.productRepository.productsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/hplus/rest/products/{id}")
    public ResponseEntity getProductsByNameUsingPathVariable(@PathVariable("id")String name){
        List<Product> products = this.productRepository.productsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
