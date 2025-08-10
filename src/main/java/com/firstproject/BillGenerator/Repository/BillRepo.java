package com.firstproject.BillGenerator.Repository;

import com.firstproject.BillGenerator.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Integer> {
}
