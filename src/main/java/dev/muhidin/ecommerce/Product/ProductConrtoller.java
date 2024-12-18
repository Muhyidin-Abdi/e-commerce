package dev.muhidin.ecommerce.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductConrtoller {
    @Autowired
    private ProductService productservice;

    @GetMapping("/add/product")
    public String  addProduct (){
        return "redirect:addProduct";
    }



    @PostMapping("/add/product")
    public String addProduct (Product product){
        productservice.CreateProduct(product);
        return "redirect:/Admin/home";

    }
    @GetMapping("/update/product/{id}")
    public String  updateProduct (@PathVariable Long id, Model model){
       model.addAttribute("product", productservice.getProductById(id));
        return "UpdateProduct";
    }
    @PostMapping("/update/product")
    public String updateProduct (Product product){
        productservice.UpdateProduct(product);
        return "redirect:/Admin/home";
    }
    @DeleteMapping("/delete/product/{id}")
    public String deleteProduct (@PathVariable Long id){
        productservice.DeleteProduct(id);
        return "redirect:/Admin/home";

    }

}
