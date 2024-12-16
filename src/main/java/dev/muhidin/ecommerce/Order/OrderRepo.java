package dev.muhidin.ecommerce.Order;

import dev.muhidin.ecommerce.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    public List <Order> findByUser(User user);

}
