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

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = false)
    public void addProduct(Product product) throws ProductAlreadyExistException{
        if (productRepository.existsById(product.getId())){
            throw new ProductAlreadyExistException();
        }
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> showProductById(int id){
        return productRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Product> showProductsByName(String name) {
        return productRepository.findByName(name);
    }
}
