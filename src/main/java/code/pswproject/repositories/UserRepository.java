package code.pswproject.repositories;

import code.pswproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User>  findUserByName(String name);
    List<User>  findUserByLastName(String LastName);
    List<User>  findUserByEmail(String email);
    boolean existsByEmail(String email);

}
