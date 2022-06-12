package com.example.pswproject.services;

import com.example.pswproject.entities.User;
import com.example.pswproject.repositories.UserRepository;
import com.example.pswproject.support.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = false)
    public User addUser(User s) throws UserAlreadyExistsException{
        if(userRepository.existsUserById(s.getId())){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(s);
    }

    @Transactional(readOnly = true)
    public List<User> showAllUser(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<User> showUserByLastName(String lastName){
        return userRepository.findUserByLastName(lastName);
    }

    @Transactional(readOnly = true)
    public List<User> showUserByName(String name){
        return userRepository.findUserByName(name);
    }


}
