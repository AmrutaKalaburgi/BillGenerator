package com.firstproject.BillGenerator.Controller;

import com.firstproject.BillGenerator.Model.Customer;
import com.firstproject.BillGenerator.Model.Product;
import com.firstproject.BillGenerator.Service.Prodservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class ProdController {
    @Autowired
    private Prodservice service; // Assuming you have a service class for Product


    @GetMapping("/product")
    public String getProduct(Model model) {
        model.addAttribute("product", new Product()); // Replace with actual product object if needed)
        return "Product"; // This should return the name of the HTML template for the product page
    }

    @PostMapping("/product")
    public String addCustomer(@ModelAttribute Product product, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            throw new RuntimeException("Customer not found in session");
        }
        product.setCustomer(customer); // Set the customer for the product
        service.addProduct(product); // Update your service to accept Customer object
        return "redirect:/product"; // or any success page/view name
    }

    @GetMapping("/productlist")
    @ResponseBody
    public List<Product> getProductList() {
        return service.getAllProducts();
    }// Assuming you have a method to get all products in your service
}
