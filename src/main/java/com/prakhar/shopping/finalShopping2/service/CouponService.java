package com.prakhar.shopping.finalShopping2.service;


import com.prakhar.shopping.finalShopping2.entity.Coupon;

import java.util.List;

public interface CouponService {
    Coupon getbyId(long id);
    List<Coupon> getAllCoupons();

    public boolean findByCode(Coupon coupon);

}
