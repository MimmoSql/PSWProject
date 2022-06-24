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
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/addProduct")
    public ResponseEntity create(@RequestBody @Valid Product product){
        System.out.println(product.getId().getClass().getName());
        try{
            productService.addProduct(product);
        }catch (ProductAlreadyExistException e){
            return new ResponseEntity<>("Product already exist!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.showAllProducts();
    }

    @GetMapping("/getByName")
    public ResponseEntity getByName(@RequestBody(required = false)String name){
        List<Product> ret = productService.showProductsByName(name);
        if (ret.size() <= 0){
            return new ResponseEntity("No resolved with that name!",HttpStatus.OK);
        }
        return new ResponseEntity<>(ret,HttpStatus.OK);
    }
}
