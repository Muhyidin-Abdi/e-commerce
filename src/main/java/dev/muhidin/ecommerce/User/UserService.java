package dev.muhidin.ecommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getALLUser() {
        return  userRepo.findAll();
    }
    public User getUserById(long id) {
        return userRepo.findById(id).orElseThrow(()-> new RuntimeException("User with "+ id + " is not Found"));
    }

    public void CreateUser(User user) {
        userRepo.save(user);
    }

    public void UpdateUser(User user) {
        userRepo.findById(user.getId()).orElseThrow(()-> new RuntimeException("User with "+ user.getId() + " is not Found"));
        userRepo.save(user);
    }
    public void DeleteUser(long id) {
        userRepo.findById(id).orElseThrow(()-> new RuntimeException("User with "+ id + " is not Found"));
        userRepo.deleteById(id);
    }
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }



    public boolean ValidateAcc(String email, String password) {
        User user = userRepo.findByEmail(email);
        return user.getPassword().equals(password);
    }
}


