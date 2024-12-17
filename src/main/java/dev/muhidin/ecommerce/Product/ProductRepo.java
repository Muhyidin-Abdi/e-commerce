package dev.muhidin.ecommerce.Product;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Long> {
    public Product findByName(String name);
    @Transactional
    @Query(value = "SELECT setval(pg_get_serial_sequence('users','id'),(SELECT MAX(id) FROM users))",nativeQuery = true)
    void resetAdminSequence();


}
