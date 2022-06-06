package com.prakhar.shopping.finalShopping2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String code;
    private BigDecimal discount;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

//----------------------------------------Old---------------
//    @Transient
//    private Product product;

    //------------------AfterChanges-------------

//    @ManyToOne
//    private  Product product;

    @OneToMany
    private List<Product> productList= new ArrayList<>();

    public Coupon(String code, BigDecimal discount) {
        this.code = code;
        this.discount = discount;
    }

    public Coupon(Long id, String code, BigDecimal discount) {
        this.id = id;
        this.code = code;
        this.discount = discount;

    }
}

