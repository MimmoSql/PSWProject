package code.pswproject.repositories;

import code.pswproject.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findById(int id);
    List<Product> findByName(String name);
    List<Product> findByNameAndQuantity(String name, int quantity);
    boolean existsById(int id);

}
