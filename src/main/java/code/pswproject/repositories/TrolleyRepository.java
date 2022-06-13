package code.pswproject.repositories;


import code.pswproject.entities.Product;
import code.pswproject.entities.Trolley;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrolleyRepository extends JpaRepository<Trolley,Integer> {

    List<Trolley> findByProduct(Product product);
    List<Trolley> findByQuantity(int quantity);
}
