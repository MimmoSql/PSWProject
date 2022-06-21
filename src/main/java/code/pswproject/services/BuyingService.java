package code.pswproject.services;

import code.pswproject.entities.Buying;
import code.pswproject.entities.Product;
import code.pswproject.entities.Trolley;
import code.pswproject.entities.User;
import code.pswproject.repositories.BuyingRepository;
import code.pswproject.repositories.TrolleyRepository;
import code.pswproject.repositories.UserRepository;
import code.pswproject.support.exceptions.ProductNotAvailableException;
import code.pswproject.support.exceptions.UserNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyingService {

    private final BuyingRepository buyingRepository;
    private final UserRepository userRepository;
    private final TrolleyRepository trolleyRepository;

    @Autowired
    public BuyingService(BuyingRepository buyingRepository, UserRepository userRepository, TrolleyRepository trolleyRepository) {
        this.buyingRepository = buyingRepository;
        this.userRepository = userRepository;
        this.trolleyRepository = trolleyRepository;
    }


    public Buying addBuying(Buying buying) throws ProductNotAvailableException{
        Buying ret = buyingRepository.save(buying);
        for (Trolley t : ret.getTrolley()){
            t.setBuying(ret);
            Trolley added = trolleyRepository.save(t);
            Product product = added.getProduct();
            int newQuantity = product.getQuantity() - t.getQuantity();
            if (newQuantity < 0 ){
                throw new ProductNotAvailableException();
            }
            product.setQuantity(newQuantity);
        }
        return ret;
    }

    public List<Buying> getBuyingByUser(User user) throws UserNotExist{
        if (!userRepository.existsById(user.getId())){
            throw new UserNotExist();
        }
        return buyingRepository.findByUser(user);
    }


}
