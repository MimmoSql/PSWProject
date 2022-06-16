package code.pswproject.controllers;


import code.pswproject.entities.Buying;
import code.pswproject.entities.User;
import code.pswproject.services.BuyingService;
import code.pswproject.support.exceptions.ProductNotAvailableException;
import code.pswproject.support.exceptions.UserNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/buying")
public class BuyingController {

    @Autowired
    private BuyingService buyingService;


    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity create(@RequestBody @Valid Buying buying){
        try {
            return new ResponseEntity<>(buyingService.addBuying(buying),HttpStatus.OK);
        } catch (ProductNotAvailableException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product not available",e);
        }
    }

    @GetMapping("/{user}")
    public List<Buying> getBuying(@RequestBody @Valid User user){
        try{
            return buyingService.getBuyingByUser(user);
        }catch (UserNotExist e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not exists",e);
        }
    }


}

