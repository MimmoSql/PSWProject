package code.pswproject.services;

import code.pswproject.repositories.UserRepository;
import code.pswproject.entities.User;
import code.pswproject.support.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = false,  propagation = Propagation.REQUIRED)
    public User addUser(User user) throws UserAlreadyExistsException{
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
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

    @Transactional(readOnly = true)
    public List<User> showUSerByEmail(String email){ return userRepository.findUserByEmail(email); }


}
