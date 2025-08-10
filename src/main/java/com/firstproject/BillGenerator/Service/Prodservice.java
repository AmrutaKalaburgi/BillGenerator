package com.firstproject.BillGenerator.Service;

import com.firstproject.BillGenerator.Model.Customer;
import com.firstproject.BillGenerator.Model.Product;
import com.firstproject.BillGenerator.Repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.firstproject.BillGenerator.Repository.Repo;
import java.util.List;

@Service
public class Prodservice {

    @Autowired
    private ProdRepo repo;

    @Autowired
    private Repo repo1;

    public void addProduct(Product product) {
        double totalCost = product.getQuantity() * product.getAmount();
        product.setAmount(totalCost);
        repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}
