package com.firstproject.BillGenerator.Repository;

import com.firstproject.BillGenerator.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepo extends JpaRepository<Product,Integer> {
}
