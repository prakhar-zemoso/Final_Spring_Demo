package com.prakhar.shopping.finalShopping2.service;

import com.prakhar.shopping.finalShopping2.entity.Product;
import com.prakhar.shopping.finalShopping2.repository.ProductRepo;

import static org.junit.jupiter.api.Assertions.*;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductFinalShoppingApplicationTests {

	@MockBean
	private ProductRepo productRepo;

	@Autowired
	private ProductServiceImpl productService;





	@Test
	void getAllProduct(){
		when(productRepo.findAll())
				.thenReturn( Stream.of(new Product("Samsung TV","32 INCH",BigDecimal.valueOf(50000)), new Product("Oneplus TV","23 INCH",BigDecimal.valueOf(15000))).collect(Collectors.toList()));

		assertEquals(2, productService.getAllProduct().size());
	}

	@Test
	void deleteProductById(){
		productService.deleteProductById(1L);
		verify(productRepo).deleteById(1L);
	}

	@Test
	public void saveProduct(){
		Product coupon = new Product("Samsung Note2021","SmartPhone",BigDecimal.valueOf(50000));
		productService.saveProduct(coupon);
		verify(productRepo).save(coupon);

	}

	@Test
	void getProductByIdExpt() {
		Product product = new Product(200L,"Samsung Note2021","SmartPhone",BigDecimal.valueOf(50000));
		when(productRepo.findById(100L)).thenReturn(Optional.of(product));
		assertThrows(RuntimeException.class,()-> productService.getProductById(200L));
	}

	@Test
	void getProductById(){
		Product product = new Product(100L,"Samsung Note2021","SmartPhone",BigDecimal.valueOf(50000));
		when(productRepo.findById(100L)).thenReturn(Optional.of(product));
		assertEquals(product,productService.getProductById(100L));
	}



}
