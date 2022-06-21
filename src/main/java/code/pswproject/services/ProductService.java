package code.pswproject.services;

import code.pswproject.entities.Product;
import code.pswproject.repositories.ProductRepository;
import code.pswproject.support.exceptions.ProductAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void addProduct(Product product) throws ProductAlreadyExistException{
        if (productRepository.existsById(product.getId())){
            throw new ProductAlreadyExistException();
        }
        productRepository.save(product);
    }

    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }


    public List<Product> showProductsByName(String name) {
        return productRepository.findByName(name);
    }
}
