package code.pswproject.services;

import code.pswproject.repositories.UserRepository;
import code.pswproject.entities.User;
import code.pswproject.support.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(User user) throws UserAlreadyExistsException{
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    public List<User> showAllUser(){
        return userRepository.findAll();
    }

    public List<User> showUserByLastName(String lastName){
        return userRepository.findUserByLastName(lastName);
    }


}
