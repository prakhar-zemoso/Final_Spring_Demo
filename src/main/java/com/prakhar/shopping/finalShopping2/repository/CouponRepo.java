package com.prakhar.shopping.finalShopping2.repository;

import com.prakhar.shopping.finalShopping2.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {
    @Query("select c from Coupon c where c.code = ?1")
    Coupon findByCode(String code);

}
