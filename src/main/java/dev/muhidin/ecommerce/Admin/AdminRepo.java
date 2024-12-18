package dev.muhidin.ecommerce.Admin;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    public Admin findByEmail(String email);

    List<Admin> id(Long id);
    @Transactional
    @Query(
            value = AdminRepo.RESET_SEQUENCE_QUERY,
            nativeQuery = true
    )
    void resetAdminIdSequence();

    // Moved the query to a static final constant for better readability
    String RESET_SEQUENCE_QUERY = "SELECT setval(pg_get_serial_sequence('admin','id'),(SELECT MAX(id) FROM admin))";
}


