package dev.muhidin.ecommerce.Admin;

import dev.muhidin.ecommerce.Message.MessageService;
import dev.muhidin.ecommerce.Order.Order;
import dev.muhidin.ecommerce.Order.OrderService;
import dev.muhidin.ecommerce.Product.Product;
import dev.muhidin.ecommerce.Product.ProductService;
import dev.muhidin.ecommerce.User.User;
import dev.muhidin.ecommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class AdminController {
    @Autowired
    private AdminServices adminServices;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    private User user; //need this var to keep track of user in the last 2 controllers

    @Autowired
    private MessageService messageService;

    @GetMapping("/verifyLogin")
    public  String ValidateAcc (@ModelAttribute ("Admin") Admin admin, Model model) { // model acts like middleware blw view and controller
        if(adminServices.ValidateAcc(admin.getEmail(),admin.getPassword())){
            return "redirect:/Admin/home";
        }
        model.addAttribute("error", "Invalid email or password");
        return "LoginPage";
    }
    @GetMapping("/Admin/home")
    public  String adminHomePage (Model model) {
        model.addAttribute("AdminList",adminServices.getALLAdmin());
        model.addAttribute("UserList",userService.getALLUser());
        model.addAttribute("ProductList",productService.getALLProducts());
        model.addAttribute("OrderList",orderService.getALLOrders());
        model.addAttribute("messagesList",messageService.getALLMessage());
        return "AdminHomePage";
    }
    @PostMapping("/add/admin")
    public String CreateAdmin(Admin admin){
        adminServices.CreateAdmin(admin);
        return "redirect:/Admin/home";
    }
    @GetMapping("/update/admin/{id}")
    public String UpdateAdmin(@PathVariable Long id, Model model){
        model.addAttribute("Admin",adminServices.getAdminById(id));
        return "UpdateUser";
    }
    @PostMapping("/update/Admin")
    public String updateAdmin(Admin admin){
        adminServices.UpdateAdmin(admin);
        return "redirect:/Admin/home";
    }

    @DeleteMapping("/delete/admin/{id}")
    public String DeleteAdmin(@PathVariable Long id){
        adminServices.DeleteAdmin(id);
        return "redirect:/Admin/home";

    }
    @GetMapping("user/Login")
    private String userLogin(User user, Model model) {
        if (userService.ValidateAcc(user.getEmail(), user.getPassword())) {

            user = userService.getUserByEmail(user.getEmail());
            model.addAttribute("ordersList",orderService.findByUser(user));
            return "redirect:Login";
        }
        model.addAttribute("error", "Invalid email or password");
        return "redirect:/Login";
    }
    @GetMapping
    private String productSearch(String name, Model model) {
        Product product = productService.findProductByName(name);
        if (product != null) {
            model.addAttribute("ordersList",orderService.findByUser(user));
            model.addAttribute("product",product);
            return "redirect:/ProductPage";
        }
        model.addAttribute("error", "Product not found...");
        model.addAttribute("ordersList",orderService.findByUser(user));
        return "redirect:ProductPage";

    }

    @GetMapping("/place/order")
    public String placeOrder(Order order, Model model) {
        double amount = order.getPrice() * order.getQuantity();
        order.setPrice(amount);
        order.setUser(user);
        order.setDate(new Date());
        orderService.CreateOrder(order);
        model.addAttribute("amount",amount);
        return "OrderStaus";
    }

}
