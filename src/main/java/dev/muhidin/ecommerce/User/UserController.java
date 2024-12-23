package dev.muhidin.ecommerce.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add/user")
    public String UpdateUser(User user) {
      userService.CreateUser(user);
      userRepo.resetUserSequence();
      return "redirect:/Admin/home";
    }

    @GetMapping("/update/user/{id}")
    public String UpdateUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "UpdateUser";
    }
    @PostMapping("/update/user")
    public String updateAdmin(User user){
        userService.UpdateUser(user);
        return "redirect:/Admin/home";
    }
    @DeleteMapping("/delete/User/{id}")
    public String DeleteUser(@PathVariable Long id){
        userService.DeleteUser(id);
        return "redirect:/Admin/home";
    }
}
