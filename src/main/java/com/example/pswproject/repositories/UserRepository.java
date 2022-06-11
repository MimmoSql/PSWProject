package com.example.pswproject.repositories;

import com.example.pswproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User>  findUserByName(String name);
    boolean existsUserById(int id);
}
