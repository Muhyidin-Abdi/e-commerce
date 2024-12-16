package dev.muhidin.ecommerce.Order;

import dev.muhidin.ecommerce.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getALLOrders() {
        return  orderRepo.findAll();
    }
    public Order getOrderById(long id) {
        return orderRepo.findById(id).orElseThrow(()-> new RuntimeException("Admin with "+ id + " is not Found"));
    }

    public void CreateOrder(Order order) {
        orderRepo.save(order);
    }

    public void UpdateOrder(Order order) {
        orderRepo.findById(order.getId()).orElseThrow(()-> new RuntimeException("Admin with "+ order.getId() + " is not Found"));
        orderRepo.save(order);
    }
    public void DeleteOrder(long id) {
        orderRepo.findById(id).orElseThrow(()-> new RuntimeException("Admin with "+ id + " is not Found"));
        orderRepo.deleteById(id);
    }
    public List<Order> findByUser(User user) {
        return orderRepo.findByUser(user);
    }

}


