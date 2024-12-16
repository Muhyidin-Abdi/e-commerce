package dev.muhidin.ecommerce.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>  {
    public Admin findByEmail(String email);

    List<Admin> id(Long id);
}
