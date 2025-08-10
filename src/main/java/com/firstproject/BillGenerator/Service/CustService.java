package com.firstproject.BillGenerator.Service;

import com.firstproject.BillGenerator.Model.Customer;
import com.firstproject.BillGenerator.Repository.Repo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustService {
    @Autowired
    private Repo repo;
    public Customer addCustomer(Customer customer) {

        // Assuming the Customer class has fields like id, name, phoneNo, etc.
        // If you need to set these fields, you can do so here.
        // For example:
        // int id = customer.getId();
        // String name = customer.getCustName();
        // String phoneNo = customer.getPhoneNo();

        // Uncomment and modify the following lines if you need to set specific fields
//        Customer customer = new Customer();
//        customer.setId(id);
//        customer.setCustName(name);
//        customer.setPhoneNo(phoneNo);
       return repo.save(customer);
        // Logic to add a customer
        // This could involve saving the customer to a database or performing other operations

    }
}
