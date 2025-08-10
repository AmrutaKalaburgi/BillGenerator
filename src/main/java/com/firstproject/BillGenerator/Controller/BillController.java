package com.firstproject.BillGenerator.Controller;

import com.firstproject.BillGenerator.BillGeneratorApplication;
import com.firstproject.BillGenerator.Model.Bill;
import com.firstproject.BillGenerator.Model.Customer;
import com.firstproject.BillGenerator.Model.Product;
import com.firstproject.BillGenerator.Repository.BillRepo;
import com.firstproject.BillGenerator.Service.Prodservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class BillController {

    @Autowired
    private Prodservice service;

    @Autowired
    private BillRepo repo;
    @PostMapping("/AddBill")
//    @ResponseBody
    public String generateBill(HttpSession session, Model model) {
        Customer customer=(Customer) session.getAttribute("customer");
        Bill bill = new Bill();
        bill.setBillDate(LocalDate.now());
        bill.setCustomerName(customer.getCustName());
        List<Product> productList = service.getAllProducts();

        double total = productList.stream()
                .mapToDouble(Product::getAmount)
                .sum();
        bill.setTotalAmount(total);
        model.addAttribute("bill", bill);
        model.addAttribute("products", productList);
        model.addAttribute("total", total);
        repo.save(bill);
        return "Bill";
       // This should be a view name or a redirect to a success page



    }


}
