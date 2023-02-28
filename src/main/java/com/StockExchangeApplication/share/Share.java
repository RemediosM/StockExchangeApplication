package com.StockExchangeApplication.share;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "share")
public class Share {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "CompanyUrlPart")
    private String companyUrlPart;
    @Column(name = "Qty")
    private int qty;
    @Column(name = "PurchasePrice")
    private float purchasePrice;
    @Column(name = "ExpectedPrice")
    private float expectedPrice;

}

