package com.prakhar.shopping.finalShopping2.controller;

import com.prakhar.shopping.finalShopping2.exceptionHandlers.UserNameAlreadyExists;
import com.prakhar.shopping.finalShopping2.entity.Coupon;
import com.prakhar.shopping.finalShopping2.repository.CouponRepo;
import com.prakhar.shopping.finalShopping2.service.CouponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@EnableAutoConfiguration
@Controller
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CouponService couponService;

    @GetMapping("/createCoupon")
    public String showCreateCoupon(){
        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon){

        if(couponService.findByCode(coupon)){
            new UserNameAlreadyExists("Coupon already exists");
            System.out.println("data already exist");
            return "errorCoupon";

        }
        couponRepo.save(coupon);
        return ("createResonse");
    }

    @GetMapping("/errorCoupon")
    public String error1(){
        return "errorCoupon";
    }


    @GetMapping("/showCoupon")
    public String showGetCoupon(Model model){
        model.addAttribute("result",couponService.getAllCoupons());
        return "getCoupon";
    }

    @PostMapping("/couponDetails")
    public ModelAndView getCoupon(String code){
        ModelAndView mav = new ModelAndView("couponDetails");
        mav.addObject(couponRepo.findByCode(code));
        return mav;
    }

}
