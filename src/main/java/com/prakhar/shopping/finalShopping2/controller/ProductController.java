package com.prakhar.shopping.finalShopping2.controller;


import com.prakhar.shopping.finalShopping2.entity.Product;
import com.prakhar.shopping.finalShopping2.repository.CouponRepo;
import com.prakhar.shopping.finalShopping2.repository.ProductRepo;
import com.prakhar.shopping.finalShopping2.security.SecurityService;
import com.prakhar.shopping.finalShopping2.service.CouponServiceImpl;
import com.prakhar.shopping.finalShopping2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
//@RequestMapping(value = "/productapi")
public class ProductController {

    @Autowired
    ProductRepo repo;

    @Autowired
    private CouponServiceImpl couponService;

    @Autowired
    CouponRepo couponRepo;

    @Autowired
    private ProductServiceImpl productService;



    @Autowired
    private SecurityService securityService;

    @GetMapping("/productIndex")
    public String AdminHomePage(Model model){
        model.addAttribute("listProduct", productService.getAllProduct());
        BigDecimal totalValue = BigDecimal.valueOf(0);
        for(Product p: productService.getAllProduct()) {
            totalValue = totalValue.add(p.getPrice());
        }


        model.addAttribute("totalPrice",totalValue);
        return "index2";

    }

    @PostMapping("/productIndex")
    public String login(String email, String password){

        boolean loginresponse = securityService.login(email, password);
        if (loginresponse){
            return "redirect:index";
        }
        return "login";
    }


    @GetMapping("/newProductForm")
    public String showNewEmployeeForm(Model model){

        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult result){

        if(result.hasErrors()){
            //return "errorPage";
            return "newProduct";
        }
//
        productService.saveProduct(product);
        return "redirect:/productIndex";
    }

    @GetMapping("/updateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute(("product"),product);
        return "update_Product";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id){
        productService.deleteProductById(id);
        return "redirect:/productIndex";
    }

}
