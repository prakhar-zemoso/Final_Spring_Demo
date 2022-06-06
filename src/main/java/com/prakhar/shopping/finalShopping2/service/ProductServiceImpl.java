package com.prakhar.shopping.finalShopping2.service;


import com.prakhar.shopping.finalShopping2.entity.Coupon;
import com.prakhar.shopping.finalShopping2.entity.Product;
import com.prakhar.shopping.finalShopping2.repository.CouponRepo;
import com.prakhar.shopping.finalShopping2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements  ProductService{


        @Autowired
        private ProductRepo productRepo;

        @Autowired
        private CouponRepo couponRepo;



    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
       // List<Coupon> couponList = product.getCoupon();

       // if (!couponList.isEmpty()){
            product.setPrice(product.getPrice().subtract(product.getCoupon().getDiscount()));
       // }
        this.productRepo.save(product);

    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepo.findById(id);
        Product product = null;
        if(optional.isPresent())
            product = optional.get();
        else {
            throw new RuntimeException("Product not found for the Id ::" +id);
        }
        return product;
    }

    @Override
    public void deleteProductById(long id) {
        this.productRepo.deleteById(id);

    }
}
