package dev.muhidin.ecommerce.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    public Product findByName(String name);

}
