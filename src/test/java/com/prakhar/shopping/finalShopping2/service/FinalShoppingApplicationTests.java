package com.prakhar.shopping.finalShopping2.service;

import com.prakhar.shopping.finalShopping2.entity.Coupon;
import com.prakhar.shopping.finalShopping2.repository.CouponRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class FinalShoppingApplicationTests {

	@MockBean
	private CouponRepo couponRepo;

	@Autowired
	private CouponServiceImpl couponService;

	@Test
	void getbyId(){
		Coupon coupon = new Coupon("Supper100", BigDecimal.valueOf(1000));
		when(couponRepo.findById(4L)).thenReturn(Optional.of(coupon));

		assertEquals(coupon,couponService.getbyId(4l));
	}

	@Test
	void getAllCoupons(){
		when(couponRepo.findAll())
				.thenReturn(Stream.of(new Coupon("Ram20",BigDecimal.valueOf(250)), new Coupon("VKB",BigDecimal.valueOf(200))).collect(Collectors.toList()));

		assertEquals(2, couponService.getAllCoupons().size());
	}


}
