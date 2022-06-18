package code.pswproject.repositories;

import code.pswproject.entities.Buying;
import code.pswproject.entities.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BuyingRepository extends JpaRepository<Buying, Integer> {

    List<Buying> findByUser(User user);

}
