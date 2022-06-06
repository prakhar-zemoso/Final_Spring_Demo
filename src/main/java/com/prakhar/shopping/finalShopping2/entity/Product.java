package com.prakhar.shopping.finalShopping2.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2,max = 50,message = "Product Name should not be blank ")
    private String name;
    @Size(min = 2,max = 50,message = "Product Desc should not be Blank ")
    private String description;

    public Product(long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    private BigDecimal price;


//    public List<Coupon> getCoupon() {
//        return coupon;
//    }
//
//    public void setCoupon(List<Coupon> coupon) {
//        this.coupon = coupon;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", coupon=" + coupon +
                '}';
    }

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "MYPRODUCT_MYCOUPON",joinColumns = @JoinColumn(name = "Product_ID"),inverseJoinColumns = @JoinColumn(name = "Coupon_ID"))
//    List<Coupon> coupon = new ArrayList<>();


//    @OneToMany
//    private List<Coupon> coupon= new ArrayList<>();

    @ManyToOne
    private  Coupon coupon;



    public Product() {
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
