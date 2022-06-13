package code.pswproject.controllers;


import code.pswproject.entities.User;
import code.pswproject.services.UserService;
import com.example.pswproject.support.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid User user){
        try {
            User u = userService.addUser(user);
            return new ResponseEntity(u, HttpStatus.OK);
        }
        catch (UserAlreadyExistsException e){
            return new ResponseEntity("User is alaready regiestrer",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<User> getAll(){
        return userService.showAllUser();
    }

    @GetMapping("/find/by_lastName")
    public ResponseEntity getByLastName(@RequestParam(required = false) String lastName){
        List<User> l = userService.showUserByLastName(lastName);
        if (l.size() <= 0){
            return new ResponseEntity<>("Not found",HttpStatus.OK);
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

}
