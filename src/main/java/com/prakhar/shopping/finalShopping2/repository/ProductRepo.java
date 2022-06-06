package com.prakhar.shopping.finalShopping2.repository;


import com.prakhar.shopping.finalShopping2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {


}
