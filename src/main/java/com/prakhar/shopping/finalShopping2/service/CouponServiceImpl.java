package com.prakhar.shopping.finalShopping2.service;


import com.prakhar.shopping.finalShopping2.entity.Coupon;
import com.prakhar.shopping.finalShopping2.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponRepo couponRepo;



    @Override
    public Coupon getbyId(long id) {
        Optional<Coupon> coupon = couponRepo.findById(id);
        return coupon.orElse(null);
    }

    @Override
    public List<Coupon> getAllCoupons() {

            return couponRepo.findAll();
        }

    @Override
    public boolean findByCode(Coupon coupon) {
         return couponRepo.findByCode(coupon.getCode())== null?false:true;
    }

}
