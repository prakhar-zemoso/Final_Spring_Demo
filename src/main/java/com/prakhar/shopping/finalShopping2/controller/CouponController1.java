package com.prakhar.shopping.finalShopping2.controller;

import com.prakhar.shopping.finalShopping2.entity.Coupon;
import com.prakhar.shopping.finalShopping2.repository.CouponRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponController1 {

    @Autowired
     private CouponRepo couponRepo;

    @RequestMapping(value = "/coupons", method = RequestMethod.POST)
    public Coupon create (@RequestBody  Coupon coupon){
        return couponRepo.save(coupon);
    }

    @RequestMapping(value ="/coupons/{code}", method = RequestMethod.GET)
    public Coupon getCoupon (@PathVariable String code){
        return couponRepo.findByCode(code);
    }


}
