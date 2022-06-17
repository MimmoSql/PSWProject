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
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BuyingService {
    @Autowired
    private BuyingRepository buyingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrolleyRepository trolleyRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = false)
    public Buying addBuying(Buying buying) throws ProductNotAvailableException{
        Buying ret = buyingRepository.save(buying);
        for (Trolley t : ret.getTrolley()){
            t.setBuying(ret);
            Trolley added = trolleyRepository.save(t);
            entityManager.refresh(added);
            Product product = added.getProduct();
            int newQuantity = product.getQuantity() - t.getQuantity();
            if (newQuantity < 0 ){
                throw new ProductNotAvailableException();
            }
            product.setQuantity(newQuantity);
            entityManager.refresh(t);
        }
        entityManager.refresh(ret);
        return ret;
    }

    @Transactional(readOnly = true)
    public List<Buying> getBuyingByUser(User user) throws UserNotExist{
        if (!userRepository.existsUserById(user.getId())){
            throw new UserNotExist();
        }
        return buyingRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public List<Buying> getAllBuying(){
        return buyingRepository.findAll();
    }

}
