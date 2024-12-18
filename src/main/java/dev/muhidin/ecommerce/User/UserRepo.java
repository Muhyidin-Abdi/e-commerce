package dev.muhidin.ecommerce.User;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepo extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    @Transactional
    @Query(value = "SELECT setval(pg_get_serial_sequence('users','id'),(SELECT MAX(id) FROM users))",nativeQuery = true)
    void resetUserSequence();

}
