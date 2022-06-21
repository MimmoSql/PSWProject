package code.pswproject.controllers;


import code.pswproject.entities.User;
import code.pswproject.services.UserService;
import code.pswproject.support.exceptions.UserAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody @Valid User user){
        try {
            User u = userService.addUser(user);
            return new ResponseEntity(u, HttpStatus.CREATED);
        }
        catch (UserAlreadyExistsException e){
            return new ResponseEntity("User is alaready regiestrer",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<User> getAll(){
        return userService.showAllUser();
    }

    public ResponseEntity getByLastName(@RequestParam(required = false) String lastName){
        List<User> l = userService.showUserByLastName(lastName);
        if (l.size() <= 0){
            return new ResponseEntity<>("Not found",HttpStatus.OK);
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

}
