package com.firstproject.BillGenerator.Repository;

import com.firstproject.BillGenerator.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.classfile.Interfaces;

@Repository
public interface Repo extends JpaRepository<Customer,Integer> {
}
