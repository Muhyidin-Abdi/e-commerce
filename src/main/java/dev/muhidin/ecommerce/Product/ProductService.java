package dev.muhidin.ecommerce.Product;

import dev.muhidin.ecommerce.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getALLProducts() {
        return  productRepo.findAll();
    }
    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product with "+ id + " is not Found"));
    }

    public void CreateProduct(Product product) {
        productRepo.save(product);
    }

    public void UpdateProduct(Product product) {
        productRepo.findById(product.getId()).orElseThrow(()-> new RuntimeException("Admin with "+ product.getId() + " is not Found"));
        productRepo.save(product);
    }
    public void DeleteProduct(long id) {
        productRepo.findById(id).orElseThrow(()-> new RuntimeException("Admin with "+ id + " is not Found"));
        productRepo.deleteById(id);
    }

    public  Product findProductByName(String name) {
        return productRepo.findByName(name);
    }
}


