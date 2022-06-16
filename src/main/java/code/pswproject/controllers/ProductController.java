package code.pswproject.controllers;


import code.pswproject.entities.Product;
import code.pswproject.services.ProductService;
import code.pswproject.support.exceptions.ProductAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Product product){
        try{
            productService.addProduct(product);
        }catch (ProductAlreadyExistException e){
            return new ResponseEntity<>("Product already exist!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.showAllProducts();
    }

    @GetMapping("/search/by_name")
    public ResponseEntity getByName(@RequestBody(required = false)String name){
        List<Product> ret = productService.showProductsByName(name);
        if (ret.size() <= 0){
            return new ResponseEntity("No resolved with that name!",HttpStatus.OK);
        }
        return new ResponseEntity<>(ret,HttpStatus.OK);
    }
}