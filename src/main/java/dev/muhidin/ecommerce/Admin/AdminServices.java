package dev.muhidin.ecommerce.Admin;

import dev.muhidin.ecommerce.User.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    @Autowired
    private AdminRepo adminRepo;


    public List<Admin> getALLAdmin() {
    return  adminRepo.findAll();
    }
    public Admin getAdminById(long id) {
     return adminRepo.findById(id).orElseThrow(()-> new RuntimeException("Admin with "+ id + " is not Found"));
    }
    public void UpdateAdmin(Admin admin) {
        adminRepo.findById(admin.getId()).orElseThrow(()-> new RuntimeException("Admin with "+ admin.getId() + " is not Found"));
        adminRepo.save(admin);
    }
    public void CreateAdmin(Admin admin) {
        adminRepo.save(admin);
        adminRepo.resetAdminIdSequence();
    }

    public void DeleteAdmin(long id) {
        adminRepo.findById(id).orElseThrow(()-> new RuntimeException("Admin with "+ id + " is not Found"));
        adminRepo.deleteById(id);
    }
    public boolean ValidateAcc(String email, String password) {
        Admin admin = adminRepo.findByEmail(email);
        return admin.getPassword().equals(password);
    }
}
