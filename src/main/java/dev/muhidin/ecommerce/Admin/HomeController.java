package dev.muhidin.ecommerce.Admin;


import dev.muhidin.ecommerce.Message.Message;
import dev.muhidin.ecommerce.Product.Product;
import dev.muhidin.ecommerce.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> productList = productService.getALLProducts();
        model.addAttribute("productList", productList);
        return "productPage"; // Name of the Thymeleaf template
    }

    @GetMapping({"/","/Home"})
    public String homePage(){
        return "HomePage";
    }
    @GetMapping("/Contact")
    public String ContactPage(Model model){
       model.addAttribute("message",new Message());
        return "/ContactUS";
    }
    @GetMapping("/AboutUs")
    public String aboutPage(){
        return "AboutPage";
    }

    @GetMapping("/Login")
    public String loginPage(Model model){
        model.addAttribute("user", new Admin());
        return "LoginPage";
    }

}
