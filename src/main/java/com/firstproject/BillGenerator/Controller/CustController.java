package com.firstproject.BillGenerator.Controller;


import com.firstproject.BillGenerator.Model.Customer;
import com.firstproject.BillGenerator.Service.CustService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
@Controller
@CrossOrigin
public class CustController {

    @Autowired
    private CustService service;
//
//    @GetMapping("/customer")
//    public String showCustomerForm() {
//        return "Customer"; // Renders Customer.html
//    }
//
//
//    @PostMapping("/customer")
//    public String addCustomer(@RequestParam int id,
//                              @RequestParam String custName,
//                              @RequestParam String phoneNo ){
//        service.addCustomer(id, custName, phoneNo);
//        // Logic to add a customer
//        return "Customer added successfully";
//    }
@GetMapping("/customer")
public String showCustomerForm(Model model) {
    model.addAttribute("customer", new Customer()); // This is needed for Thymeleaf form binding
    return "Customer";
}
    @PostMapping("/customer")
    public String SaveCustomer(@ModelAttribute Customer customer, HttpSession session) {
        Customer savedCustomer =service.addCustomer(customer);
        session.setAttribute("customer", savedCustomer);
         // Update your service to accept Customer object
        return "redirect:/product"; // or any success page/view name
    }

}
