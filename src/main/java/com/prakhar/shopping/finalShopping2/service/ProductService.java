package com.prakhar.shopping.finalShopping2.service;


import com.prakhar.shopping.finalShopping2.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void saveProduct(Product Product);
    Product getProductById(long id);
    void deleteProductById(long id);

}
