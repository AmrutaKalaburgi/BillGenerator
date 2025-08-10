package com.firstproject.BillGenerator.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    private LocalDate billDate;
    private String customerName;
    private double totalAmount;


}
