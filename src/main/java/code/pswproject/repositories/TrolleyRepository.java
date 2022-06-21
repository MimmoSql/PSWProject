package code.pswproject.repositories;

import code.pswproject.entities.Trolley;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrolleyRepository extends JpaRepository<Trolley,Integer> {
    boolean existsById(Integer integer);
}
